package com.syne.asn.datasource.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syne.asn.datasource.entity.Organization;
import com.syne.asn.datasource.entity.OrganizationDetail;
import com.syne.asn.datasource.service.repository.OrgSearchRepository;

/*
 * @author subhajit
 *
 */
@RestController
@RequestMapping("/orgsearch")
public class OrgSearchController {
	public static final Logger logger = LoggerFactory.getLogger(OrgSearchController.class);

	@Autowired
	OrgSearchRepository orgSearchRepository;

	@RequestMapping(value = "/{orgId}", method = RequestMethod.GET)
	public Organization getOrgById(@PathVariable("orgId") int orgId) {
		logger.info("get organization by id:", orgId);

		Organization org = orgSearchRepository.findOne(orgId);
		return org;
	}

	@RequestMapping(value = "/details/{orgId}", method = RequestMethod.GET)
	public OrganizationDetail getOrgDetailsById(@PathVariable("orgId") int orgId) {
		logger.info("get organization details by id:", orgId);

		OrganizationDetail orgDetail = orgSearchRepository.getOrgDetails(orgId);
		return orgDetail;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Organization> getAllOrg() {
		logger.info("get all organizations");
		return orgSearchRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public List<Organization> getOrgs(@RequestBody Organization org) {
		logger.info("get organization");
		return orgSearchRepository.getOrgs(org);

	}
}
