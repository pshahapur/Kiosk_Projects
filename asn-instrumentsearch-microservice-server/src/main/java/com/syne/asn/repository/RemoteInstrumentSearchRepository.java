package com.syne.asn.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.syne.asn.dto.InstrumentDto;
import com.syne.asn.dto.InstrumentMetaInfoDto;
import com.syne.asn.dto.InstrumentRegulationDto;

/*
 * @author subhajit
 */
public class RemoteInstrumentSearchRepository implements InstrumentSearchRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteInstrumentSearchRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public List<InstrumentDto> getAllInstruments() {
		return restTemplate.getForObject(serviceUrl + "/instrumentsearch/all", List.class);
	}

	@Override
	public List<InstrumentDto> getInstruments(InstrumentDto instrumentDto) {
		return restTemplate.postForObject(serviceUrl + "/instrumentsearch", instrumentDto, List.class);
	}

	@Override
	public Map<Integer, InstrumentMetaInfoDto> getInstrumentByNameOrId(String name, Integer id) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(serviceUrl + "/instrumentsearch")
				.queryParam("name", name).queryParam("id", id);
		return restTemplate.getForObject(builder.toUriString(), Map.class);
	}

	@Override
	public List<InstrumentRegulationDto> getInstrumentRegulationById(Integer instId) {
		return restTemplate.getForObject(serviceUrl + "/instrumentsearch/instrumentregulation/{instId}", List.class,
				instId);
	}

}
