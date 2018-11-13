package com.syne.asn.datasource.controller;

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

import com.syne.asn.datasource.entity.InstrumentRegulation;
import com.syne.asn.datasource.entity.Regulation;
import com.syne.asn.datasource.service.repository.InstrumentRegulationRepository;
import com.syne.asn.datasource.service.repository.RegulationRepository;

/*
 * @author subhajit
 *
 */
@RestController
@RequestMapping("/regulation")
public class RegulationController {
	public static final Logger logger = LoggerFactory.getLogger(RegulationController.class);

	@Autowired
	RegulationRepository regulationRepos;
	@Autowired
	InstrumentRegulationRepository instRegRepos;

	@RequestMapping(value = "/{regId}", method = RequestMethod.GET)
	public Regulation getRegulationById(@PathVariable("regId") int regId) {
		logger.info("get regulation by Id:", regId);
		return regulationRepos.findOne(regId);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<InstrumentRegulation> updateInstrumentRegulation(@RequestBody InstrumentRegulation instReg) {
		logger.info("Updating instrument regulation");
		InstrumentRegulation rsltInstReg = instRegRepos
				.getInstrumentRegulationByInstIdAndRegId(instReg.getInstrumentId(), instReg.getRegulationId());
		if (rsltInstReg == null) {
			instRegRepos.save(instReg);
		} else {
			instRegRepos.updateInstrumentRegulation(instReg.getRiskProfileId(), instReg.getInstrumentId(),
					instReg.getRegulationId());
		}
		return new ResponseEntity<InstrumentRegulation>(HttpStatus.OK);
	}
}
