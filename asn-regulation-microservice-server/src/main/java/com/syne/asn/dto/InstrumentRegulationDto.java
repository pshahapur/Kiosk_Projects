package com.syne.asn.dto;

import java.io.Serializable;

/*
 * @author subhajit
 */

public class InstrumentRegulationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int instrumentId;
	private int regulationId;
	private int riskProfileId;

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
}