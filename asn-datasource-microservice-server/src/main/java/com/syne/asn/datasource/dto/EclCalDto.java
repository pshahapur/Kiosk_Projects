package com.syne.asn.datasource.dto;

import java.io.Serializable;

/*
 * @author subhajit
 */
public class EclCalDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private InstrumentDto instDto;
	private Integer accountId;
	private Integer orgId;
	private String type;
	private Integer month;
	private Integer regulationId;

	public InstrumentDto getInstDto() {
		return instDto;
	}

	public void setInstDto(InstrumentDto instDto) {
		this.instDto = instDto;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(Integer regulationId) {
		this.regulationId = regulationId;
	}
}
