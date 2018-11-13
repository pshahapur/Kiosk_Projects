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

import com.syne.asn.dto.OrganizationDetailDto;
import com.syne.asn.dto.OrganizationDto;
import com.syne.asn.respository.OrgSearchRepository;

/*
 * @author subhajit
 */
@RestController
@CrossOrigin
//@RequestMapping("/asn/org")
public class OrgSearchController {

	@Autowired
	OrgSearchRepository orgSearchRepos;

	public static final Logger logger = LoggerFactory.getLogger(OrgSearchController.class);

	@RequestMapping(value = "/{orgId}", method = RequestMethod.GET)
	public ResponseEntity<OrganizationDto> getOrgById(@PathVariable("orgId") int orgId) {
		OrganizationDto orgDto = orgSearchRepos.getOrgById(orgId);
		return new ResponseEntity<OrganizationDto>(orgDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/details/{orgId}", method = RequestMethod.GET)
	public ResponseEntity<OrganizationDetailDto> getOrgDetailsById(@PathVariable("orgId") int orgId) {
		logger.info("Get organizations details by id: " + orgId);
		OrganizationDetailDto orgDetDto = orgSearchRepos.getOrgDetailsById(orgId);
		return new ResponseEntity<OrganizationDetailDto>(orgDetDto, HttpStatus.OK);
	}

	@RequestMapping(/*value="/all", */method = RequestMethod.GET)
	public ResponseEntity<List<OrganizationDto>> getAllOrgs() {
		logger.info("get all organizations");
		List<OrganizationDto> orgList = orgSearchRepos.getAllOrgs();
		return new ResponseEntity<List<OrganizationDto>>(orgList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<OrganizationDto>> getOrgs(@RequestBody OrganizationDto orgDto) {
		logger.info("get organizations: " + orgDto);
		List<OrganizationDto> orgList = orgSearchRepos.getOrgs(orgDto);

		return new ResponseEntity<List<OrganizationDto>>(orgList, HttpStatus.OK);
	}
}