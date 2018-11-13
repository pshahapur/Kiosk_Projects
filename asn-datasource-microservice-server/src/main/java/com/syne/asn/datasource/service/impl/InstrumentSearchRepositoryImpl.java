package com.syne.asn.datasource.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.syne.asn.datasource.dto.InstrumentMetaInfoDto;
import com.syne.asn.datasource.entity.Instrument;
import com.syne.asn.datasource.service.repository.InstrumentSearchRepositoryCustom;

/*
 * @author subhajit
 */
public class InstrumentSearchRepositoryImpl implements InstrumentSearchRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Instrument> getInstruments(Instrument instrument) {
		StringBuilder sql = new StringBuilder("select e from Instrument e where 1=1 ");
		if (instrument.getInstrumentId() != null) {
			sql.append(" AND e.instrumentId = " + instrument.getInstrumentId());
		}
		if (instrument.getName() != null) {
			sql.append(" AND e.name = '" + instrument.getName() + "'");
		}
		if (instrument.getIsin() != null) {
			sql.append(" AND e.isin = '" + instrument.getIsin() + "'");
		}
		if (instrument.getParentInstrumentId() != null) {
			sql.append(" AND e.parentInstrumentId = " + instrument.getParentInstrumentId());
		}
		if (instrument.getIdentifierType() != null) {
			sql.append(" AND e.identifierType = '" + instrument.getIdentifierType() + "'");
		}
		if (instrument.getIdentifierValue() != null) {
			sql.append(" AND e.identifierValue = '" + instrument.getIdentifierValue() + "'");
		}
		if (instrument.getTypeId() != null) {
			sql.append(" AND e.typeId = " + instrument.getTypeId());
		}
		if (instrument.getFromDate() != null) {
			sql.append(" AND e.fromDate = " + instrument.getFromDate());
		}
		if (instrument.getToDate() != null) {
			sql.append(" AND e.toDate = " + instrument.getToDate());
		}
		List<Instrument> result = em.createQuery(sql.toString()).getResultList();
		return result;
	}

	@Override
	public Map<Integer, InstrumentMetaInfoDto> getInstrumentByNameAndId(String name, Integer id) {
		InstrumentMetaInfoDto instrumentMetaInfo = null;
		Map<Integer, InstrumentMetaInfoDto> instInfoMap = new HashMap<Integer, InstrumentMetaInfoDto>();
		StringBuilder sql = new StringBuilder("select i.name,i.identifierType,b.category,b.subCategory,b.moodyRating,");
		sql.append(
				"b.spRating,b.paymentFrequency,b.maturityDate,b.couponRate,b.callable,r.name,r.state,ir.regulationId,ir.riskProfileId,i.instrumentId,b.industryGroup,b.industrySubGroup");
		sql.append(" from Instrument i,Bonds b,Region r,InstrumentRegulation ir");
		sql.append(" where i.instrumentId = b.bondId");
		sql.append(" and b.regionId = r.regionId");
		sql.append(" and i.instrumentId = ir.instrumentId");
		if (id != null && id != 0) {
			sql.append(" and i.instrumentId = " + id);
		} else if (name != null) {
			sql.append(" and UPPER(i.name) like UPPER('%" + name + "%')");
		}

		List<Object[]> results = em.createQuery(sql.toString()).getResultList();
		if (results != null) {
			for (Object[] result : results) {

				int regId = (Integer) result[12];
				int riskId = (Integer) result[13];
				int instId = (Integer) result[14];

				if (instInfoMap.containsKey(instId)) {
					instrumentMetaInfo = instInfoMap.get(instId);
					instrumentMetaInfo.setRegulationMap(getRegulationMap(instrumentMetaInfo, regId, riskId));

				} else {
					instrumentMetaInfo = new InstrumentMetaInfoDto();
					instrumentMetaInfo.setRegulationMap(getRegulationMap(instrumentMetaInfo, regId, riskId));
					instInfoMap.put(instId, instrumentMetaInfo);
					if (result[0] != null) {
						instrumentMetaInfo.setName((String) result[0]);
					}
					if (result[1] != null) {
						instrumentMetaInfo.setIdentifierType((String) result[1]);
					}
					if (result[2] != null) {
						instrumentMetaInfo.setCategory((String) result[2]);
					}
					if (result[3] != null) {
						instrumentMetaInfo.setSubCategory((String) result[3]);
					}
					if (result[4] != null) {
						instrumentMetaInfo.setMoodyRating((String) result[4]);
					}
					if (result[5] != null) {
						instrumentMetaInfo.setSpRating((String) result[5]);
					}
					if (result[6] != null) {
						instrumentMetaInfo.setPaymentFrequency((String) result[6]);
					}
					// if (result[7] != null) {
					// instrumentMetaInfo.setMaturity(null);
					// }
					if (result[8] != null) {
						instrumentMetaInfo.setCouponRate((Double) result[8]);
					}
					if (result[9] != null) {
						instrumentMetaInfo.setCallable((Integer) result[9]);
					}
					if (result[10] != null) {
						instrumentMetaInfo.setRegionName((String) result[10]);
					}
					if (result[11] != null) {
						instrumentMetaInfo.setState((String) result[11]);
					}
					if (result[15] != null) {
						instrumentMetaInfo.setIndustryGroup(((String) result[15]).trim());
					}
					if (result[16] != null) {
						instrumentMetaInfo.setIndustrySubGroup(((String) result[16]).trim());
					}
				}
			}
		}

		return instInfoMap;
	}

	private Map<Integer, Integer> getRegulationMap(InstrumentMetaInfoDto instrumentMetaInfo, int regId, int riskId) {
		Map<Integer, Integer> regMap = instrumentMetaInfo.getRegulationMap();
		if (regMap != null) {
			regMap.put(regId, riskId);
		} else {
			regMap = new HashMap<Integer, Integer>();
			regMap.put(regId, riskId);
		}
		instrumentMetaInfo.setRegulationMap(regMap);
		return regMap;
	}

	@Override
	public List<Instrument> getAllInstruments() {
		StringBuilder sql = new StringBuilder(
				"SELECT new com.syne.asn.datasource.entity.Instrument(i.instrumentId,i.name,i.isin,i.parentInstrumentId,i.identifierType,i.identifierValue,i.typeId,");
		sql.append("i.fromDate,i.toDate,b.couponRate,b.maturityDate) ");
		sql.append("FROM Instrument i,Bonds b ");
		sql.append("WHERE i.instrumentId=b.bondId");
		List<Instrument> instrumentLst = em.createQuery(sql.toString()).getResultList();
		return instrumentLst;
	}
}
