package com.syne.asn.datasource.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/*
 * @author subhajit
 */
public class InstrumentDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer instrumentId;
	private String instrumentName;
	private List<Integer> regulationId;
	private Map<Integer, Integer> regRiskMap;

	public Integer getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public List<Integer> getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(List<Integer> regulationId) {
		this.regulationId = regulationId;
	}

	public Map<Integer, Integer> getRegRiskMap() {
		return regRiskMap;
	}

	public void setRegRiskMap(Map<Integer, Integer> regRiskMap) {
		this.regRiskMap = regRiskMap;
	}

}
