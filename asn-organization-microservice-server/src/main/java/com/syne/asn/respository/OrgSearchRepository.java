package com.syne.asn.respository;

import java.util.List;

import com.syne.asn.dto.OrganizationDetailDto;
import com.syne.asn.dto.OrganizationDto;

/*
 * @author subhajit
 */
public interface OrgSearchRepository {

	OrganizationDto getOrgById(int orgId);

	List<OrganizationDto> getAllOrgs();

	List<OrganizationDto> getOrgs(OrganizationDto orgDto);

	OrganizationDetailDto getOrgDetailsById(Integer orgId);
}
