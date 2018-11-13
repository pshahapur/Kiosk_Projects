package com.syne.asn.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syne.asn.dto.InstrumentDto;
import com.syne.asn.dto.InstrumentMetaInfoDto;
import com.syne.asn.dto.InstrumentRegulationDto;
import com.syne.asn.repository.InstrumentSearchRepository;

/*
 * @author subhajit
 */
@RestController
@CrossOrigin
//@RequestMapping("/asn/instrument")
public class InstrumentSearchController {

	@Autowired
	InstrumentSearchRepository instrSearchRepos;

	public static final Logger logger = LoggerFactory.getLogger(InstrumentSearchController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<Integer, InstrumentMetaInfoDto>> getInstrumentByNameOrId(@RequestParam String name,
			@RequestParam(required = false, defaultValue = "0") Integer id) {

		Map<Integer, InstrumentMetaInfoDto> instMetaInfoDtoMap = instrSearchRepos.getInstrumentByNameOrId(name, id);

		return new ResponseEntity<Map<Integer, InstrumentMetaInfoDto>>(instMetaInfoDtoMap, HttpStatus.OK);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<InstrumentDto>> getAllInstruments() {
		logger.info("get all instruments");
		List<InstrumentDto> instrumentList = instrSearchRepos.getAllInstruments();
		return new ResponseEntity<List<InstrumentDto>>(instrumentList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<InstrumentDto>> getInstruments(@RequestBody InstrumentDto instrumentDto) {
		logger.info("get instruments: " + instrumentDto);
		List<InstrumentDto> instrumentList = instrSearchRepos.getInstruments(instrumentDto);
		return new ResponseEntity<List<InstrumentDto>>(instrumentList, HttpStatus.OK);
	}

	@RequestMapping(value = "/instrumentregulation/{instId}", method = RequestMethod.GET)
	public ResponseEntity<List<InstrumentRegulationDto>> getInstrumentRegulation(@PathVariable("instId") int instId) {
		logger.info("get instruments regulation by id:" + instId);
		List<InstrumentRegulationDto> instReguList = instrSearchRepos.getInstrumentRegulationById(instId);
		return new ResponseEntity<List<InstrumentRegulationDto>>(instReguList, HttpStatus.OK);
	}

}
