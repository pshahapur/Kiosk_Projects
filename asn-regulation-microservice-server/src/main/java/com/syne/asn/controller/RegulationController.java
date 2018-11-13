package com.syne.asn.controller;

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

import com.syne.asn.dto.InstrumentRegulationDto;
import com.syne.asn.dto.RegulationDto;
import com.syne.asn.respository.RegulationRepository;

/*
 * @author subhajit
 */
@RestController
@CrossOrigin
//@RequestMapping("/asn/regulation")
public class RegulationController {
	@Autowired
	RegulationRepository regulationRepos;

	public static final Logger logger = LoggerFactory.getLogger(RegulationController.class);

	@RequestMapping(value = "/{regId}", method = RequestMethod.GET)
	public ResponseEntity<RegulationDto> getRegulationById(@PathVariable("regId") int regId) {
		RegulationDto regDto = regulationRepos.getRegulationById(regId);
		return new ResponseEntity<RegulationDto>(regDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<InstrumentRegulationDto> updateInstrumentRegulation(
			@RequestBody InstrumentRegulationDto insRegDto) {
		logger.info("Updating instrument regulation");
		regulationRepos.updateInstrumentRegulation(insRegDto);
		return new ResponseEntity<InstrumentRegulationDto>(HttpStatus.OK);
	}
}
