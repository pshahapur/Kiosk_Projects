package com.syne.asn.datasource.service.repository;

import java.util.List;

import com.syne.asn.datasource.entity.Organization;

/*
 * @author subhajit
 */
public interface OrgSearchRepositoryCustom {
	List<Organization> getOrgs(Organization org);
}
