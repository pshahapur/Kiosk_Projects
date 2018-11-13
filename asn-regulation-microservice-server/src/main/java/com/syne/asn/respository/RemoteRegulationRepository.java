package com.syne.asn.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.syne.asn.dto.InstrumentRegulationDto;
import com.syne.asn.dto.RegulationDto;

/*
 * @author subhajit
 */

public class RemoteRegulationRepository implements RegulationRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteRegulationRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public RegulationDto getRegulationById(int regId) {
		return restTemplate.getForObject(serviceUrl + "/regulation/{id}", RegulationDto.class, regId);
	}

	@Override
	public void updateInstrumentRegulation(InstrumentRegulationDto insRegDto) {
		restTemplate.put(serviceUrl + "/regulation/update", insRegDto);
	}
}