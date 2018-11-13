package com.syne.asn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syne.asn.dto.RiskProfileDto;
import com.syne.asn.repository.RiskProfileRepository;

/*
 * @author subhajit
 */
@RestController
@CrossOrigin
//@RequestMapping("/asn/riskprofile")
public class RiskProfileController {

	@Autowired
	RiskProfileRepository riskProfileRepository;

	public static final Logger logger = LoggerFactory.getLogger(RiskProfileController.class);

	@RequestMapping(value = "/{riskProfileId}", method = RequestMethod.GET)
	public ResponseEntity<RiskProfileDto> getRisprofileById(@PathVariable("riskProfileId") int riskProfileId) {
		RiskProfileDto riskProfileDto = riskProfileRepository.getRiskProfileById(riskProfileId);
		return new ResponseEntity<RiskProfileDto>(riskProfileDto, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RiskProfileDto>> getAllRiskProfile() {
		logger.info("get all risk profile");
		List<RiskProfileDto> riskProfileList = riskProfileRepository.getAllRiskProfile();
		return new ResponseEntity<List<RiskProfileDto>>(riskProfileList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{riskProfileId}", method = RequestMethod.PUT)
	public ResponseEntity<RiskProfileDto> updateRiskProfile(@PathVariable("riskProfileId") int riskProfileId,
			@RequestBody RiskProfileDto riskProfileDto) {
		logger.info("Updating RiskProfile with riskProfileId ", riskProfileId);

		RiskProfileDto riskProfileEntity = riskProfileRepository.getRiskProfileById(riskProfileId);

		if (riskProfileEntity == null) {
			return new ResponseEntity<RiskProfileDto>(HttpStatus.NOT_FOUND);
		}

		riskProfileEntity.setName(riskProfileDto.getName());
		riskProfileEntity.setDescription(riskProfileDto.getDescription());
		riskProfileEntity.setRiskFactors(riskProfileDto.getRiskFactors());

		riskProfileRepository.updateRiskProfile(riskProfileId, riskProfileEntity);

		return new ResponseEntity<RiskProfileDto>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RiskProfileDto> createRiskProfile(@RequestBody RiskProfileDto riskProfileDto) {
		logger.info("Create riskProfile: " + riskProfileDto);
		RiskProfileDto riskProfile = riskProfileRepository.createRiskProfile(riskProfileDto);
		return new ResponseEntity<RiskProfileDto>(riskProfile, HttpStatus.OK);
	}
}
