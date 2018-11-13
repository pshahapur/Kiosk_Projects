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
@Table(name = "RiskFactor")
public class RiskFactor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer riskFactorId;
	private String name;
	private Integer regionId;
	private Integer currencyId;
	private Integer quantModelId;
	private Date fromDate;
	private Date toDate;
	private String riskGroup;

	public Integer getRiskFactorId() {
		return riskFactorId;
	}

	public void setRiskFactorId(Integer riskFactorId) {
		this.riskFactorId = riskFactorId;
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

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Integer getQuantModelId() {
		return quantModelId;
	}

	public void setQuantModelId(Integer quantModelId) {
		this.quantModelId = quantModelId;
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
