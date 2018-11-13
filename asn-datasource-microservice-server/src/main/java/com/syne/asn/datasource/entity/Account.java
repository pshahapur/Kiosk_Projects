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
@Table(name = "Account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private String name;
	private Integer clientId;
	private Integer regulationId;
	private String acType;
	private String currencyId;
	private Integer regionId;
	private Double presentTotalValue;
	private Double principalValue;
	private Double ecl;
	private Double ecl12Month;
	private Double eclLongTerm;
	private Double lgd;
	private Double ead;
	private Date fromDate;
	private Date toDate;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(Integer regulationId) {
		this.regulationId = regulationId;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
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

	public Double getPresentTotalValue() {
		return presentTotalValue;
	}

	public void setPresentTotalValue(Double presentTotalValue) {
		this.presentTotalValue = presentTotalValue;
	}

	public Double getPrincipalValue() {
		return principalValue;
	}

	public void setPrincipalValue(Double principalValue) {
		this.principalValue = principalValue;
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

	public Double getLgd() {
		return lgd;
	}

	public void setLgd(Double lgd) {
		this.lgd = lgd;
	}

	public Double getEad() {
		return ead;
	}

	public void setEad(Double ead) {
		this.ead = ead;
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