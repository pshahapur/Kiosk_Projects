package com.syne.asn.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * @author subhajit
 *
 */
public class RegulationDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer regulationId;
	private String name;
	private String description;
	private Integer regionId;
	private Date fromDate;
	private Date toDate;

	public Integer getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(Integer regulationId) {
		this.regulationId = regulationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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