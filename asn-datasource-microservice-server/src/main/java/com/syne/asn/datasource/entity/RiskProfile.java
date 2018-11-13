package com.syne.asn.datasource.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author subhajit
 *
 */
@Entity
@Table(name = "RiskProfile")
public class RiskProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int riskProfileId;
	private String name;
	private String description;
	private String riskFactors;
	private Date fromDate;
	private Date toDate;
	private String riskGroup;

	public RiskProfile() {

	}

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