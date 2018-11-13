package com.syne.asn.datasource.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.syne.asn.datasource.entity.Account;
import com.syne.asn.datasource.entity.AccountDetail;

/*
 * @author subhajit
 */
public interface AccountSearchRepository extends JpaRepository<Account, Integer>, AccountSearchRepositoryCustom {

	@Query("from AccountDetail a")
	List<AccountDetail> getAccountDetails();

}
