package com.syne.asn.datasource.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.syne.asn.datasource.constant.AsnConstants;
import com.syne.asn.datasource.dto.InstrumentDto;
import com.syne.asn.datasource.entity.Account;
import com.syne.asn.datasource.entity.Bonds;
import com.syne.asn.datasource.entity.EclRun;
import com.syne.asn.datasource.entity.EclRunDetail;
import com.syne.asn.datasource.entity.Instrument;
import com.syne.asn.datasource.entity.InstrumentRegulation;
import com.syne.asn.datasource.entity.Organization;
import com.syne.asn.datasource.entity.Region;
import com.syne.asn.datasource.service.repository.EclCalculationRepositoryCustom;
import com.syne.util.Util;

/*
 * @author subhajit
 */

@Transactional
public class EclCalculationRepositoryImpl implements EclCalculationRepositoryCustom {

	public static final Logger logger = LoggerFactory.getLogger(EclCalculationRepositoryImpl.class);
	@PersistenceContext
	private EntityManager em;
	private Map<Integer, EclRunDetail> eclRunDetailMap = new HashMap<Integer, EclRunDetail>();
	private boolean isAcctCall;
	private int month100 = 100;

	private int month12 = 12;

	@Override
	public List<EclRun> getInstrumentEclRun(InstrumentDto instDto) {

		List<EclRun> eclList = new ArrayList<EclRun>();
		Integer instrumentId = instDto.getInstrumentId();
		Map<Integer, Integer> regRiskMap = instDto.getRegRiskMap();
		regRiskMap.forEach((regId, riskProfId) -> {
			String regType = getRegType(regId);
			BigDecimal ecl12Month = BigDecimal.ZERO;
			BigDecimal eclLongTerm = getEcl(instrumentId, regType, month100, riskProfId);
			if (regId == 1) {
				ecl12Month = getEcl(instrumentId, regType, month12, riskProfId);
			}
			Bonds bonds = em.find(Bonds.class, instrumentId);
			int regionId = bonds.getRegionId();
			Instrument inst = em.find(Instrument.class, instrumentId);
			EclRun eclRun = insertEclRun(instrumentId, inst.getName(), "Instrument", regId, ecl12Month, eclLongTerm,
					regionId, riskProfId);
			eclList.add(eclRun);
		});
		return eclList;
	}

	private BigDecimal getEcl(Integer instrumentId, String regType, Integer month, Integer riskProfId) {

		List<Integer> riskFactors = getRiskFactors(instrumentId, regType, riskProfId); // get risk factors id
		List<Double> pdList = getPds(riskFactors, instrumentId, regType, month, riskProfId); // get pds
		BigDecimal pdAvg = getPdAvg(pdList); // get avg. PD
		BigDecimal ead = getEad(instrumentId); // get EAD
		BigDecimal lgd = getLGD(instrumentId, regType); // get lgdCoeefficient

		return calculateEcl(pdAvg, ead, lgd); // calculate ecl
	}

	private List<Integer> getRiskFactors(int instrumentId, String regType, Integer riskProfId) {

		StringBuilder sql = new StringBuilder("select rp.riskFactors");
		sql.append(" FROM RiskProfile rp,InstrumentRegulation ir,Regulation r");
		sql.append(" WHERE rp.riskProfileId = ir.riskProfileId");
		sql.append(" AND ir.instrumentId = :instrumentId");
		sql.append(" AND ir.regulationId = r.regulationId");
		sql.append(" AND r.name like '%" + regType + "%'");
		if (riskProfId != 0) {
			sql.append(" AND rp.riskProfileId = " + riskProfId);
		}
		String result = (String) em.createQuery(sql.toString()).setParameter("instrumentId", instrumentId)
				.getSingleResult();
		return Util.convertStringToListOfIntegers(result);

	}

	private List<Double> getPds(List<Integer> riskFactors, int instrumentId, String regType, Integer month,
			Integer riskProfId) {
		Bonds bonds = em.find(Bonds.class, instrumentId);
		StringBuilder sql = new StringBuilder("select p.pd");
		sql.append(regType);
		sql.append(" FROM PD p,RiskFactor rf,RiskProfile rp,");
		sql.append(" InstrumentRegulation ir,Bonds b");
		sql.append(" WHERE p.riskFactorId = rf.riskFactorId AND rf.riskFactorId IN :riskFactors");
		sql.append(" AND rp.riskProfileId = ir.riskProfileId");
		sql.append(" AND ir.instrumentId = b.bondId");
		sql.append(" AND ir.instrumentId = :instrumentId");

		if (bonds.getMoodyRating() != null && !bonds.getMoodyRating().isEmpty()) {
			sql.append(" AND Substring(coalesce(b.moodyRating,'Default'),1,1) = Substring(p.moodyRatingMin,1,1)");
		}

		sql.append(" AND p.month = :month");
		if (riskProfId != 0) {
			sql.append(" AND rp.riskProfileId = " + riskProfId);
		}
		List<Double> pdList = em.createQuery(sql.toString()).setParameter("riskFactors", riskFactors)
				.setParameter("instrumentId", instrumentId).setParameter("month", month).getResultList();

		return pdList;
	}

	private BigDecimal getPdAvg(List<Double> pdList) {
		Double pdAvg = 0.0;
		for (Double pd : pdList) {
			pdAvg = pdAvg + pd;
		}
		Double result = pdAvg / pdList.size();
		return new BigDecimal(result);
	}

	private BigDecimal getLGD(int instrumentId, String regType) {
		StringBuilder sql = null;
		Bonds bonds = em.find(Bonds.class, instrumentId);

		if (bonds.getMoodyRating() == null || bonds.getMoodyRating().isEmpty()) {
			sql = new StringBuilder("select avg(l.lgd");
			sql.append(regType);
			sql.append(")");
			sql.append(" FROM LGDCoefficients l,Bonds b");
			sql.append(" WHERE b.category = l.category");
		} else {
			sql = new StringBuilder("select l.lgd");
			sql.append(regType);
			sql.append(" FROM LGDCoefficients l,Bonds b");
			sql.append(" WHERE b.category = l.category");
			sql.append(" AND Substring(coalesce(b.moodyRating,'Default'),1,1) = Substring(l.moodyRating,1,1)");
		}
		sql.append(
				" AND FLOOR(DATEDIFF(DATE_FORMAT(b.maturityDate, '%Y-%m-%d'),DATE_FORMAT(CURRENT_TIMESTAMP, '%Y-%m-%d'))/365) >= l.maturityMin");
		sql.append(
				" AND FLOOR(DATEDIFF(DATE_FORMAT(b.maturityDate, '%Y-%m-%d'),DATE_FORMAT(CURRENT_TIMESTAMP, '%Y-%m-%d'))/365) < l.maturityMax");
		sql.append(" AND b.bondId = :instrumentId");
		Double lgdCoeff = (Double) em.createQuery(sql.toString()).setParameter("instrumentId", instrumentId)
				.getSingleResult();
		return new BigDecimal(lgdCoeff);
	}

	// ECL calculation
	private BigDecimal calculateEcl(BigDecimal pdAvg, BigDecimal ead, BigDecimal lgd) {
		BigDecimal ecl = pdAvg.multiply(ead).multiply(lgd);
		return ecl;
	}

	private BigDecimal getEad(int instrumentId) {
		String sql = "select b.outstandingAmount from Bonds b where b.bondId = :instrumentId";
		Double result = (Double) em.createQuery(sql).setParameter("instrumentId", instrumentId).getSingleResult();
		return new BigDecimal(result);
	}

	@Override
	public List<EclRun> getAccountEclRun(Integer accountId) {
		isAcctCall = true;
		List<EclRun> eclList = new ArrayList<EclRun>();
		Account account = em.find(Account.class, accountId);
		Integer regId = account.getRegulationId();
		Integer regionId = account.getRegionId();
		BigDecimal ecl12Month = BigDecimal.ZERO;
		BigDecimal eclLongTerm = getAccountEcl(accountId, month100, regId);
		if (regId == 1) {
			ecl12Month = getAccountEcl(accountId, month12, regId);
		}
		EclRun eclRun = insertEclRun(accountId, account.getName(), "Account", regId, ecl12Month, eclLongTerm, regionId,
				null);
		List<EclRunDetail> eclRunDetailLst = insertEclRunDetail(eclRun);
		eclRun.setEclRunDetailLst(eclRunDetailLst);
		eclList.add(eclRun);
		return eclList;
	}

	private BigDecimal getAccountEcl(Integer accountId, Integer month, Integer regId) {

		BigDecimal ecl = BigDecimal.ZERO;
		String regType = null;

		String sqlAcct = "select ad.instrumentId from AccountDetail ad where ad.accountId = :accountId";
		List<Integer> instIdLst = em.createQuery(sqlAcct).setParameter("accountId", accountId).getResultList();
		regType = getRegType(regId); // all instrument will have same regulation Type for an account

		if (instIdLst != null && !instIdLst.isEmpty()) {
			for (Integer instId : instIdLst) {
				String sqlInsReg = "select ir from InstrumentRegulation ir where ir.instrumentId = :instId";
				List<InstrumentRegulation> instRegLst = em.createQuery(sqlInsReg).setParameter("instId", instId)
						.getResultList();
				for (InstrumentRegulation instReg : instRegLst) {
					if (instReg.getRegulationId() == regId) {// match regulation for account & instrument
						EclRunDetail eclRunDetail;
						BigDecimal currentEcl = getEcl(instId, regType, month, instReg.getRiskProfileId());
						if (isAcctCall) {
							if (eclRunDetailMap.containsKey(instId)) {
								eclRunDetail = eclRunDetailMap.get(instId);
								eclRunDetail = setEclBasedOnMonth(eclRunDetail, month, currentEcl);
							} else {
								Bonds bonds = em.find(Bonds.class, instId);
								int regionId = bonds.getRegionId();
								Region region = em.find(Region.class, regionId);
								Instrument inst = em.find(Instrument.class, instId);
								eclRunDetail = setEclBasedOnMonth(new EclRunDetail(instId, "Instrument", inst.getName(),
										region.getName(), region.getCountry(), regId), month, currentEcl);
								eclRunDetailMap.put(instId, eclRunDetail);
							}
						}
						ecl = ecl.add(currentEcl);
					}
				}
			}
		}
		return ecl;
	}

	private String getRegType(Integer regId) {
		String regType = null;
		switch (regId) {
		case 1:
			regType = AsnConstants.IFRS;
			break;
		case 2:
			regType = AsnConstants.GAAP;
			break;
		case 3:
			regType = AsnConstants.BASEL;
			break;

		default:
			break;
		}
		return regType;
	}

	private EclRun insertEclRun(Integer id, String name, String type, Integer regId, BigDecimal ecl12Month,
			BigDecimal eclLongTerm, Integer regionId, Integer riskProfId) {
		Region region = em.find(Region.class, regionId);
		EclRun eclRun = new EclRun(id, name, regId, type, ecl12Month, eclLongTerm, regionId, region.getName(),
				region.getCountry(), riskProfId);
		em.persist(eclRun);
		em.flush();

		logger.info(String.format(
				"inserted record for ECL run with EclRun runId: %d , id: %d , Type: %s having eclLongTerm: %f",
				eclRun.getRunId(), id, type, eclLongTerm));

		return eclRun;
	}

	private List<EclRunDetail> insertEclRunDetail(EclRun eclRun) {
		List<EclRunDetail> eclRunDetailLst = new ArrayList<EclRunDetail>();
		eclRunDetailMap.forEach((id, eclRunDetail) -> {
			eclRunDetail.setRunId(eclRun.getRunId());
			em.persist(eclRunDetail);
			em.flush();
			eclRunDetailLst.add(eclRunDetail);
		});
		eclRunDetailMap.clear();
		return eclRunDetailLst;
	}

	@Override
	public List<EclRun> getOrganizationEclRun(Integer orgId) {
		isAcctCall = false;
		List<EclRun> eclList = new ArrayList<EclRun>();
		Organization organization = em.find(Organization.class, orgId);
		Integer regId = organization.getRegulationId();
		Integer regionId = organization.getRegionId();
		BigDecimal ecl12Month = BigDecimal.ZERO;
		BigDecimal eclLongTerm = getOrganizationEcl(orgId, month100, regId);
		if (regId == 1) {
			ecl12Month = getOrganizationEcl(orgId, month12, regId);
		}
		EclRun eclRun = insertEclRun(orgId, organization.getName(), "Organization", regId, ecl12Month, eclLongTerm,
				regionId, null);
		List<EclRunDetail> eclRunDetailLst = insertEclRunDetail(eclRun);
		eclRun.setEclRunDetailLst(eclRunDetailLst);
		eclList.add(eclRun);
		return eclList;
	}

	private BigDecimal getOrganizationEcl(Integer orgId, Integer month, Integer regId) {
		BigDecimal ecl = BigDecimal.ZERO;
		String sql = "select a.accountId from Account a where a.clientId = :orgId";
		List<Integer> acctIdList = em.createQuery(sql).setParameter("orgId", orgId).getResultList();
		if (acctIdList != null && !acctIdList.isEmpty()) {
			for (Integer acctId : acctIdList) {
				EclRunDetail eclRunDetail;
				Account acct = em.find(Account.class, acctId);
				BigDecimal currentEcl = getAccountEcl(acctId, month, regId);
				if (eclRunDetailMap.containsKey(acctId)) {
					eclRunDetail = eclRunDetailMap.get(acctId);
					eclRunDetail = setEclBasedOnMonth(eclRunDetail, month, currentEcl);
				} else {
					int regionId = acct.getRegionId();
					Region region = em.find(Region.class, regionId);
					eclRunDetail = setEclBasedOnMonth(new EclRunDetail(acctId, "Account", acct.getName(),
							region.getName(), region.getCountry(), regId), month, currentEcl);
					eclRunDetailMap.put(acctId, eclRunDetail);
				}
				ecl = ecl.add(currentEcl);
			}
		}
		return ecl;
	}

	private EclRunDetail setEclBasedOnMonth(EclRunDetail eclRunDetail, Integer month, BigDecimal currentEcl) {
		if (month == month100) {
			eclRunDetail.setEclLongTerm(currentEcl);
		} else {
			eclRunDetail.setEcl12Month(currentEcl);
		}
		return eclRunDetail;
	}

	@Override
	public List<EclRun> getEclHistoryData(Integer id, String type, Integer regulationId,
			Map<Integer, Integer> regRiskMap) {
		List<EclRun> eclList = new ArrayList<EclRun>();
		int[] monthsBack = { 0, 1, 2, 3, 4, 5, 6 };
		EclRun eclRun = null;
		StringBuilder sql = null;
		List<Object[]> results = null;
		List<Integer> runIdLst = new ArrayList<Integer>();
		for (int monthBack : monthsBack) {
			if (regRiskMap != null) {
				regRiskMap.forEach((regId, riskProfId) -> {
					StringBuilder regulationSql = new StringBuilder("select Max(RunId) from ECLRun Where id =:id");
					regulationSql.append(" AND idType= :idType");
					regulationSql.append(" AND MONTH(fromDate) = MONTH(CURRENT_DATE - INTERVAL ");
					regulationSql.append(monthBack + " MONTH)");
					regulationSql.append(" AND RegulationId= :regId");
					List<Integer> runIdMaxList = em.createNativeQuery(regulationSql.toString()).setParameter("id", id)
							.setParameter("idType", type).setParameter("regId", regId).getResultList();
					if (runIdMaxList != null && !runIdMaxList.isEmpty()) {
						runIdLst.add(runIdMaxList.get(0));
					}
				});
			}

			sql = new StringBuilder("select * from ECLRun e Where e.id =:id");
			sql.append(" AND e.idType= :idType");
			sql.append(" AND MONTH(e.fromDate) = MONTH(CURRENT_DATE - INTERVAL ");
			sql.append(monthBack + " MONTH)");
			if (runIdLst.isEmpty()) {
				sql.append(" AND e.regulationId= :regulationId");
				sql.append(" AND e.runId =(");
				sql.append("select max(RunId) from ECLRun Where id =:id");
				sql.append(" AND idType= :idType");
				sql.append(" AND MONTH(fromDate) = MONTH(CURRENT_DATE - INTERVAL ");
				sql.append(monthBack + " MONTH)");
				sql.append(" AND regulationId= :regulationId");
				sql.append(")");
			} else {
				sql.append(" AND e.runId  IN :runIdLst");
			}

			if (runIdLst.isEmpty()) {
				results = em.createNativeQuery(sql.toString()).setParameter("id", id).setParameter("idType", type)
						.setParameter("regulationId", regulationId).getResultList();
			} else {
				results = em.createNativeQuery(sql.toString()).setParameter("id", id).setParameter("idType", type)
						.setParameter("runIdLst", runIdLst).getResultList();
			}

			if (results != null) {
				for (Object[] result : results) {
					eclRun = new EclRun();
					if (result[0] != null) {
						eclRun.setRunId((Integer) result[0]);
					}
					if (result[1] != null) {
						eclRun.setDescription((String) result[1]);
					}
					if (result[2] != null) {
						eclRun.setQuantModelID((Integer) result[2]);
					}
					if (result[3] != null) {
						eclRun.setRegulationId((Integer) result[3]);
					}
					if (result[4] != null) {
						eclRun.setRiskProfileId((Integer) result[4]);
					}
					if (result[5] != null) {
						eclRun.setId((Integer) result[5]);
					}
					if (result[6] != null) {
						eclRun.setIdType((String) result[6]);
					}
					if (result[7] != null) {
						eclRun.setRegionId((Integer) result[7]);
					}
					if (result[8] != null) {
						eclRun.setEcl((BigDecimal) result[8]);
					}
					if (result[9] != null) {
						eclRun.setEcl12Month((BigDecimal) result[9]);
					}
					if (result[10] != null) {
						eclRun.setEclLongTerm((BigDecimal) result[10]);
					}
					// if (result[11] != null) {
					// eclRun.setFromDate(result[11]);
					// }
					// if (result[12] != null) {
					// eclRun.setToDate((Double) result[12]);
					// }
					if (result[13] != null) {
						eclRun.setName((String) result[13]);
					}
					eclRun.setMonth(monthBack);
					eclList.add(eclRun);
				}
			}
		}
		return eclList;
	}

	@Override
	public List<EclRunDetail> getEclSubHistoryData(Integer id, String type, Integer regulationId) {
		List<EclRunDetail> eclList = new ArrayList<EclRunDetail>();
		int[] monthsBack = { 0, 1, 2, 3, 4, 5, 6 };
		EclRunDetail eclRunDetail = null;
		StringBuilder sql = null;
		List<Object[]> results = null;
		for (int monthBack : monthsBack) {
			sql = new StringBuilder("select * from ECLRunDetail e Where e.id =:id");
			sql.append(" AND e.idType= :idType");
			sql.append(" AND MONTH(e.fromDate) = MONTH(CURRENT_DATE - INTERVAL ");
			sql.append(monthBack + " MONTH)");
			sql.append(" AND e.regulationId= :regulationId");
			sql.append(" AND e.runId =(");
			sql.append("select max(RunId) from ECLRunDetail Where id =:id");
			sql.append(" AND idType= :idType");
			sql.append(" AND MONTH(fromDate) = MONTH(CURRENT_DATE - INTERVAL ");
			sql.append(monthBack + " MONTH)");
			sql.append(" AND regulationId= :regulationId");
			sql.append(")");

			results = em.createNativeQuery(sql.toString()).setParameter("id", id).setParameter("idType", type)
					.setParameter("regulationId", regulationId).getResultList();

			if (results != null) {
				for (Object[] result : results) {
					eclRunDetail = new EclRunDetail();
					if (result[0] != null) {
						eclRunDetail.setRunId((Integer) result[0]);
					}
					if (result[1] != null) {
						eclRunDetail.setRunDetailId((Integer) result[1]);
					}
					if (result[2] != null) {
						eclRunDetail.setId((Integer) result[2]);
					}
					if (result[3] != null) {
						eclRunDetail.setEcl((BigDecimal) result[3]);
					}
					if (result[4] != null) {
						eclRunDetail.setEcl12Month((BigDecimal) result[4]);
					}
					if (result[5] != null) {
						eclRunDetail.setEclLongTerm((BigDecimal) result[5]);
					}
					// if (result[6] != null) {
					// eclRun.setFromDate(result[6]);
					// }
					// if (result[7] != null) {
					// eclRun.setToDate((Double) result[7]);
					// }
					if (result[8] != null) {
						eclRunDetail.setIdType((String) result[8]);
					}
					if (result[9] != null) {
						eclRunDetail.setName((String) result[9]);
					}
					if (result[11] != null) {
						eclRunDetail.setRegulationId((Integer) result[11]);
					}
					eclRunDetail.setMonth(monthBack);
					eclList.add(eclRunDetail);
				}
			}
		}
		return eclList;
	}
}
