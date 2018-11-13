package com.syne.asn.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.syne.asn.dto.OrganizationDetailDto;
import com.syne.asn.dto.OrganizationDto;

/*
 * @author subhajit
 */
public class RemoteOrgSearchRepository implements OrgSearchRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteOrgSearchRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public OrganizationDto getOrgById(int orgId) {
		return restTemplate.getForObject(serviceUrl + "/orgsearch/{id}", OrganizationDto.class, orgId);
	}

	@Override
	public List<OrganizationDto> getOrgs(OrganizationDto orgDto) {
		return restTemplate.postForObject(serviceUrl + "/orgsearch", orgDto, List.class);
	}

	@Override
	public List<OrganizationDto> getAllOrgs() {
		return restTemplate.getForObject(serviceUrl + "/orgsearch", List.class);
	}

	@Override
	public OrganizationDetailDto getOrgDetailsById(Integer orgId) {
		return restTemplate.getForObject(serviceUrl + "/orgsearch/details/{id}", OrganizationDetailDto.class, orgId);
	}

}
