package com.syne.asn.datasource.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syne.asn.datasource.entity.RiskProfile;
import com.syne.asn.datasource.service.repository.RiskProfileRepository;

/*
 * @author subhajit
 *
 */
@RestController
@RequestMapping("/riskprofile")
public class RiskProfileController {
	public static final Logger logger = LoggerFactory.getLogger(RiskProfileController.class);

	@Autowired
	RiskProfileRepository riskProfileRepository;

	@RequestMapping(value = "/{riskProfileId}", method = RequestMethod.GET)
	public RiskProfile getRiskProfileById(@PathVariable("riskProfileId") int riskProfileId) {
		logger.info("get risk profile:", riskProfileId);
		return riskProfileRepository.findOne(riskProfileId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<RiskProfile> getAllRiskProfile() {
		logger.info("get all risk profile");
		return riskProfileRepository.findAll();
	}

	@RequestMapping(value = "/{riskProfileId}", method = RequestMethod.PUT)
	public ResponseEntity<RiskProfile> updateRiskProfile(@PathVariable("riskProfileId") int riskProfileId,
			@RequestBody RiskProfile riskProfile) {
		logger.info("Updating RiskProfile with riskProfileId ", riskProfileId);
		riskProfileRepository.updateRiskProfile(riskProfileId, riskProfile.getRiskFactors());
		return new ResponseEntity<RiskProfile>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public RiskProfile createRiskProfile(@RequestBody RiskProfile riskProfile) {
		logger.info("Create RiskProfile");
		return riskProfileRepository.save(riskProfile);
	}

}
