package com.syne.asn.datasource.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.syne.asn.datasource.entity.Organization;
import com.syne.asn.datasource.entity.OrganizationDetail;

/*
 * @author subhajit
 */
public interface OrgSearchRepository extends JpaRepository<Organization, Integer>, OrgSearchRepositoryCustom {
	@Query("from OrganizationDetail a where a.organizationId = :orgId")
	OrganizationDetail getOrgDetails(@Param("orgId") Integer orgId);
}
