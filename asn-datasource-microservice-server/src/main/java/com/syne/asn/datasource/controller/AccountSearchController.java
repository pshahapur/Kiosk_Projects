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

import com.syne.asn.datasource.entity.Account;
import com.syne.asn.datasource.entity.AccountDetail;
import com.syne.asn.datasource.service.repository.AccountSearchRepository;

/*
 * @author subhajit
 *
 */
@RestController
@RequestMapping("/accountsearch")
public class AccountSearchController {
	public static final Logger logger = LoggerFactory.getLogger(AccountSearchController.class);

	@Autowired
	AccountSearchRepository accountSearchRepos;

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable("accountId") int accountId) {
		logger.info("get account by id:", accountId);

		Account account = accountSearchRepos.findOne(accountId);
		return account;
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public List<AccountDetail> getAccountDetails() {
		logger.info("get account details");

		List<AccountDetail> accountDetailsList = accountSearchRepos.getAccountDetails();
		return accountDetailsList;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Account> getAllAccounts() {
		logger.info("get all accounts");
		return accountSearchRepos.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public List<Account> getAccounts(@RequestBody Account account) {
		logger.info("get accounts");
		return accountSearchRepos.getAccounts(account);
	}
}
