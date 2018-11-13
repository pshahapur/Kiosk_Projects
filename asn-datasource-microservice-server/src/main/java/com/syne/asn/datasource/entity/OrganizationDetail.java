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
@Table(name = "OrganizationDetail")
public class OrganizationDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orgDetailId;
	private Integer organizationId;
	private Integer regulationId;
	private Integer accountId;
	private String currencyId;
	private Integer regionId;
	private Double ecl;
	private Double ecl12Month;
	private Double eclLongTerm;
	private Date fromDate;
	private Date toDate;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getOrgDetailId() {
		return orgDetailId;
	}

	public void setOrgDetailId(Integer orgDetailId) {
		this.orgDetailId = orgDetailId;
	}

	public Integer getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(Integer regulationId) {
		this.regulationId = regulationId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Double getEcl() {
		return ecl;
	}

	public void setEcl(Double ecl) {
		this.ecl = ecl;
	}

	public Double getEcl12Month() {
		return ecl12Month;
	}

	public void setEcl12Month(Double ecl12Month) {
		this.ecl12Month = ecl12Month;
	}

	public Double getEclLongTerm() {
		return eclLongTerm;
	}

	public void setEclLongTerm(Double eclLongTerm) {
		this.eclLongTerm = eclLongTerm;
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