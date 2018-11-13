package com.syne.asn.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.syne.asn.dto.AccountDetailDto;
import com.syne.asn.dto.AccountDto;

/*
 * @author subhajit
 */
public class RemoteAccountSearchRepository implements AccountSearchRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteAccountSearchRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public AccountDto getAccountById(int accountId) {
		return restTemplate.getForObject(serviceUrl + "/accountsearch/{id}", AccountDto.class, accountId);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		return restTemplate.getForObject(serviceUrl + "/accountsearch", List.class);
	}

	@Override
	public List<AccountDto> getAccounts(AccountDto accountDto) {
		return restTemplate.postForObject(serviceUrl + "/accountsearch", accountDto, List.class);
	}

	@Override
	public List<AccountDetailDto> getAccountDetails() {
		return restTemplate.getForObject(serviceUrl + "/accountsearch/details", List.class);
	}

}
