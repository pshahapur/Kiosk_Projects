package com.syne.asn.repository;

import java.util.List;

import com.syne.asn.dto.AccountDetailDto;
import com.syne.asn.dto.AccountDto;

/*
 * @author subhajit
 */
public interface AccountSearchRepository {

	AccountDto getAccountById(int accountId);

	List<AccountDto> getAccounts(AccountDto accountDto);

	List<AccountDto> getAllAccounts();

	List<AccountDetailDto> getAccountDetails();

}
