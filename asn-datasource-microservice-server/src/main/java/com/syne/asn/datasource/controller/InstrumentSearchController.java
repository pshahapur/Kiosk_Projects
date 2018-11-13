package com.syne.asn.datasource.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syne.asn.datasource.dto.InstrumentMetaInfoDto;
import com.syne.asn.datasource.entity.Instrument;
import com.syne.asn.datasource.entity.InstrumentRegulation;
import com.syne.asn.datasource.service.repository.InstrumentRegulationRepository;
import com.syne.asn.datasource.service.repository.InstrumentSearchRepository;

/*
 * @author subhajit
 *
 */
@RestController
@RequestMapping("/instrumentsearch")
public class InstrumentSearchController {
	public static final Logger logger = LoggerFactory.getLogger(InstrumentSearchController.class);

	@Autowired
	InstrumentSearchRepository instrumentSearchRepository;
	@Autowired
	InstrumentRegulationRepository instrumentRegulationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Map<Integer, InstrumentMetaInfoDto> getInstrumentByNameAndId(@RequestParam String name,
			@RequestParam(required = false, defaultValue = "0") Integer id, HttpServletRequest req)
			throws UnsupportedEncodingException {
		String decodedName = null;
		if (name != null) {
			decodedName = URLDecoder.decode(name, "UTF-8");
		}

		logger.info(String.format("get instrument by id: %d and name: %s", id, decodedName));

		Map<Integer, InstrumentMetaInfoDto> instMetaInfoDtoMap = instrumentSearchRepository
				.getInstrumentByNameAndId(decodedName, id);
		return instMetaInfoDtoMap;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Instrument> getAllInstruments() {
		logger.info("get all instruments");
		return instrumentSearchRepository.getAllInstruments();
	}

	@RequestMapping(method = RequestMethod.POST)
	public List<Instrument> getInstruments(@RequestBody Instrument instrument) {
		logger.info("get instruments");
		return instrumentSearchRepository.getInstruments(instrument);
	}

	@RequestMapping(value = "/instrumentregulation/{instId}", method = RequestMethod.GET)
	public List<InstrumentRegulation> getInstrumentRegulationById(@PathVariable("instId") int instId) {
		logger.info("get Instrument Regulation by id:" + instId);
		return instrumentRegulationRepository.getInstrumentRegulationById(instId);
	}
}
