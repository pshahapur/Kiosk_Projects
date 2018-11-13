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

import com.syne.asn.dto.AccountDetailDto;
import com.syne.asn.dto.AccountDto;
import com.syne.asn.repository.AccountSearchRepository;

/*
 * @author subhajit
 */
@RestController
@CrossOrigin
//@RequestMapping("/asn/account")
public class AccountSearchController {

	@Autowired
	AccountSearchRepository acntSearchRepos;

	public static final Logger logger = LoggerFactory.getLogger(AccountSearchController.class);

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("accountId") int accountId) {
		logger.info("Get accounts by id: " + accountId);
		AccountDto accountDto = acntSearchRepos.getAccountById(accountId);
		return new ResponseEntity<AccountDto>(accountDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<List<AccountDetailDto>> getAccountDetails() {
		logger.info("Get accounts details ");
		List<AccountDetailDto> accountDtoList = acntSearchRepos.getAccountDetails();
		return new ResponseEntity<List<AccountDetailDto>>(accountDtoList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		List<AccountDto> accountList = acntSearchRepos.getAllAccounts();
		return new ResponseEntity<List<AccountDto>>(accountList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<AccountDto>> getAccounts(@RequestBody AccountDto accountDto) {
		logger.info("Get accounts: " + accountDto);
		List<AccountDto> accountList = acntSearchRepos.getAccounts(accountDto);

		return new ResponseEntity<List<AccountDto>>(accountList, HttpStatus.OK);
	}

}