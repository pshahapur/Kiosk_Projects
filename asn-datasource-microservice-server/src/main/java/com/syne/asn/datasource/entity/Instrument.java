package com.syne.asn.datasource.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * @author subhajit
 *
 */
@Entity
@Table(name = "Instrument")
public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer instrumentId;
	private String name;
	private String isin;
	private Integer parentInstrumentId;
	private String identifierType;
	private String identifierValue;
	private Integer typeId;
	private Date fromDate;
	private Date toDate;
	@Transient
	private Double couponRate;
	@Transient
	Date maturityDate;

	public Instrument() {

	}

	public Instrument(Integer instrumentId, String name, String isin, Integer parentInstrumentId, String identifierType,
			String identifierValue, Integer typeId, Date fromDate, Date toDate, Double couponRate, Date maturityDate) {
		this.instrumentId = instrumentId;
		this.name = name;
		this.isin = isin;
		this.parentInstrumentId = parentInstrumentId;
		this.identifierType = identifierType;
		this.identifierValue = identifierValue;
		this.typeId = typeId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.couponRate = couponRate;
		this.maturityDate = maturityDate;
	}

	public Integer getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public Integer getParentInstrumentId() {
		return parentInstrumentId;
	}

	public void setParentInstrumentId(Integer parentInstrumentId) {
		this.parentInstrumentId = parentInstrumentId;
	}

	public String getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}

	public String getIdentifierValue() {
		return identifierValue;
	}

	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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

	public Double getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(Double couponRate) {
		this.couponRate = couponRate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

}