package com.syne.asn.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * @author subhajit
 */
public class RiskProfileDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int riskProfileId;
	private String name;
	private String description;
	private String riskFactors;
	private Date fromDate;
	private Date toDate;
	private String riskGroup;

	public int getRiskProfileId() {
		return riskProfileId;
	}

	public void setRiskProfileId(int riskProfileId) {
		this.riskProfileId = riskProfileId;
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

	public String getRiskFactors() {
		return riskFactors;
	}

	public void setRiskFactors(String riskFactors) {
		this.riskFactors = riskFactors;
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

	public String getRiskGroup() {
		return riskGroup;
	}

	public void setRiskGroup(String riskGroup) {
		this.riskGroup = riskGroup;
	}
}
