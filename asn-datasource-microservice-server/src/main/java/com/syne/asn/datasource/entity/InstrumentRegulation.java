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
@Table(name = "InstrumentRegulation")
public class InstrumentRegulation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instrumentRegulationId;
	private int instrumentId;
	private int regulationId;
	private int riskProfileId;
	private Date fromDate;
	private Date toDate;

	public int getInstrumentRegulationId() {
		return instrumentRegulationId;
	}

	public void setInstrumentRegulationId(int instrumentRegulationId) {
		this.instrumentRegulationId = instrumentRegulationId;
	}

	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public int getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(int regulationId) {
		this.regulationId = regulationId;
	}

	public int getRiskProfileId() {
		return riskProfileId;
	}

	public void setRiskProfileId(int riskProfileId) {
		this.riskProfileId = riskProfileId;
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