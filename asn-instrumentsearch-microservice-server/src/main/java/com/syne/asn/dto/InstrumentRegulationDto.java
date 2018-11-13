package com.syne.asn.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * @author subhajit
 */
public class InstrumentRegulationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int instrumentId;
	private int regulationId;
	private int riskProfileId;
	private Date fromDate;
	private Date toDate;

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