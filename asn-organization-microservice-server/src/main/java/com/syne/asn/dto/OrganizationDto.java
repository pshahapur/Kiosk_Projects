package com.syne.asn.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * @author subhajit
 */
public class OrganizationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer organizationId;
	private String name;
	private Integer regionId;
	private Date fromDate;
	private Date toDate;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
