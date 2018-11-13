package com.syne.asn.datasource.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syne.asn.datasource.dto.EclCalDto;
import com.syne.asn.datasource.entity.EclRun;
import com.syne.asn.datasource.entity.EclRunDetail;
import com.syne.asn.datasource.service.repository.EclCalculationRepository;

/*
 * @author subhajit
 *
 */

@RestController
@RequestMapping("/ecl")
public class EclCalculationController {
	public static final Logger logger = LoggerFactory.getLogger(EclCalculationController.class);

	private enum Type {
		INSTRUMENT, ACCOUNT, ORGANIZATION;
	}

	@Autowired
	EclCalculationRepository eclCalculationRepos;

	@RequestMapping(method = RequestMethod.POST)
	public List<EclRun> getEcl(@RequestBody EclCalDto eclDto) {

		List<EclRun> eclList = null;
		switch (Type.valueOf(eclDto.getType())) {
		case INSTRUMENT:
			logger.info("get ecl for instrument");
			eclList = eclCalculationRepos.getInstrumentEclRun(eclDto.getInstDto());
			break;
		case ACCOUNT:
			logger.info("get ecl for account");
			eclList = eclCalculationRepos.getAccountEclRun(eclDto.getAccountId());
			break;
		case ORGANIZATION:
			logger.info("get ecl for organization");
			eclList = eclCalculationRepos.getOrganizationEclRun(eclDto.getOrgId());
			break;
		default:
			break;
		}
		logger.info("getEcl controller return list : " +eclList);
		return eclList;
	}

	@RequestMapping(value = "/historydata", method = RequestMethod.POST)
	public List<EclRun> getEclHistoryData(@RequestBody EclCalDto eclDto) {
		List<EclRun> eclList = null;
		switch (Type.valueOf(eclDto.getType())) {
		case INSTRUMENT:
			logger.info("get ecl history data for instrument");
			eclList = eclCalculationRepos.getEclHistoryData(eclDto.getInstDto().getInstrumentId(), eclDto.getType(),
					null, eclDto.getInstDto().getRegRiskMap());
			break;
		case ACCOUNT:
			logger.info("get ecl history data for accounts");
			eclList = eclCalculationRepos.getEclHistoryData(eclDto.getAccountId(), eclDto.getType(),
					eclDto.getRegulationId(), null);
			break;
		case ORGANIZATION:
			logger.info("get ecl history data for organization");
			eclList = eclCalculationRepos.getEclHistoryData(eclDto.getOrgId(), eclDto.getType(),
					eclDto.getRegulationId(), null);
			break;
		default:
			break;
		}
		return eclList;
	}

	@RequestMapping(value = "/sub/historydata", method = RequestMethod.POST)
	public List<EclRunDetail> getSubEclHistoryData(@RequestBody EclCalDto eclDto) {
		List<EclRunDetail> eclList = null;

		logger.info("get ecl sub history data");
		eclList = eclCalculationRepos.getEclSubHistoryData(eclDto.getAccountId(), eclDto.getType(),
				eclDto.getRegulationId());
		return eclList;
	}
}
