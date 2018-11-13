package com.syne.asn.datasource.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.syne.asn.datasource.entity.Account;
import com.syne.asn.datasource.service.repository.AccountSearchRepositoryCustom;

/*
 * @author subhajit
 */
public class AccountSearchRepositoryImpl implements AccountSearchRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAccounts(Account account) {
		StringBuilder sql = new StringBuilder("select e from Account e where 1=1 ");
		if (account.getAccountId() != null) {
			sql.append(" AND e.accountId = " + account.getAccountId());
		}
		if (account.getClientId() != null) {
			sql.append(" AND e.clientId = " + account.getClientId());
		}
		if (account.getAcType() != null) {
			sql.append(" AND e.acType = '" + account.getAcType() + "'");
		}
		if (account.getCurrencyId() != null) {
			sql.append(" AND e.currencyId = " + account.getCurrencyId());
		}
		if (account.getRegionId() != null) {
			sql.append(" AND e.regionId = " + account.getRegionId());
		}
		if (account.getPresentTotalValue() != null) {
			sql.append(" AND e.presentTotalValue = " + account.getPresentTotalValue());
		}
		if (account.getPrincipalValue() != null) {
			sql.append(" AND e.principalValue = " + account.getPrincipalValue());
		}
		if (account.getEcl() != null) {
			sql.append(" AND e.ecl = " + account.getEcl());
		}
		if (account.getEcl12Month() != null) {
			sql.append(" AND e.ecl12Month = " + account.getEcl12Month());
		}
		if (account.getEclLongTerm() != null) {
			sql.append(" AND e.eclLongTerm = " + account.getEclLongTerm());
		}
		if (account.getLgd() != null) {
			sql.append(" AND e.lgd = " + account.getLgd());
		}
		if (account.getEad() != null) {
			sql.append(" AND e.ead = " + account.getEad());
		}
		if (account.getFromDate() != null) {
			sql.append(" AND e.fromDate = " + account.getFromDate());
		}
		if (account.getToDate() != null) {
			sql.append(" AND e.toDate = " + account.getToDate());
		}
		List<Account> result = em.createQuery(sql.toString()).getResultList();
		return result;
	}
}