package com.syne.asn.datasource.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.syne.asn.datasource.entity.Organization;
import com.syne.asn.datasource.service.repository.OrgSearchRepositoryCustom;

/*
 * @author subhajit
 */
public class OrgSearchRepositoryImpl implements OrgSearchRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> getOrgs(Organization org) {
		StringBuilder sql = new StringBuilder("select e from Organization e where 1=1 ");
		if (org.getOrganizationId() != null) {
			sql.append(" AND e.accountId = " + org.getOrganizationId());
		}
		if (org.getName() != null) {
			sql.append(" AND e.name = '" + org.getName() + "'");
		}
		if (org.getRegionId() != null) {
			sql.append(" AND e.regionId = " + org.getRegionId());
		}
		if (org.getFromDate() != null) {
			sql.append(" AND e.fromDate = " + org.getFromDate());
		}
		if (org.getToDate() != null) {
			sql.append(" AND e.toDate = " + org.getToDate());
		}

		List<Organization> result = em.createQuery(sql.toString()).getResultList();
		return result;
	}
}