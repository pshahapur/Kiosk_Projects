package com.syne.asn.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.syne.asn.dto.RiskProfileDto;

/*
 * @author subhajit
 */
public class RemoteRiskProfileRepository implements RiskProfileRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteRiskProfileRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public RiskProfileDto getRiskProfileById(int riskProfileId) {
		return restTemplate.getForObject(serviceUrl + "/riskprofile/{id}", RiskProfileDto.class, riskProfileId);
	}

	@Override
	public void updateRiskProfile(int riskProfileId, RiskProfileDto riskProfileEntity) {
		restTemplate.put(serviceUrl + "/riskprofile/{id}", riskProfileEntity, riskProfileId);
	}

	@Override
	public List<RiskProfileDto> getAllRiskProfile() {
		return restTemplate.getForObject(serviceUrl + "/riskprofile", List.class);
	}

	@Override
	public RiskProfileDto createRiskProfile(RiskProfileDto riskProfileDto) {
		return restTemplate.postForObject(serviceUrl + "/riskprofile", riskProfileDto, RiskProfileDto.class);
	}

}
