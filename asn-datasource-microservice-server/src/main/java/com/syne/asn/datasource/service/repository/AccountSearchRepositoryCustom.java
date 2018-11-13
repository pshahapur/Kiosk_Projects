package com.syne.asn.datasource.service.repository;

import java.util.List;

import com.syne.asn.datasource.entity.Account;

/*
 * @author subhajit
 */
public interface AccountSearchRepositoryCustom {
	List<Account> getAccounts(Account account);
}
