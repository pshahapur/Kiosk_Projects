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
@Table(name = "AccountDetail")
public class AccountDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private Integer acDetailId;
	private Integer instrumentId;
	private String currencyId;
	private Integer regionId;
	private Double presentValue;
	private Double principalValue;
	private String status;
	private Double realizedGain;
	private Double unRealizedGain;
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

	public Integer getAcDetailId() {
		return acDetailId;
	}

	public void setAcDetailId(Integer acDetailId) {
		this.acDetailId = acDetailId;
	}

	public Integer getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
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

	public Double getPresentValue() {
		return presentValue;
	}

	public void setPresentValue(Double presentValue) {
		this.presentValue = presentValue;
	}

	public Double getPrincipalValue() {
		return principalValue;
	}

	public void setPrincipalValue(Double principalValue) {
		this.principalValue = principalValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getRealizedGain() {
		return realizedGain;
	}

	public void setRealizedGain(Double realizedGain) {
		this.realizedGain = realizedGain;
	}

	public Double getUnRealizedGain() {
		return unRealizedGain;
	}

	public void setUnRealizedGain(Double unRealizedGain) {
		this.unRealizedGain = unRealizedGain;
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
