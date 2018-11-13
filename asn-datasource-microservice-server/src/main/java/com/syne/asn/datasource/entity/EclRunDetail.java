package com.syne.asn.datasource.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

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
@Table(name = "ECLRunDetail")
public class EclRunDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer runDetailId;
	private Integer runId;
	private Integer regulationId;
	private Integer id;
	private String idType;
	private String name;
	private BigDecimal ecl;
	private BigDecimal ecl12Month;
	private BigDecimal eclLongTerm;
	private Date fromDate;
	private Date toDate;
	@Transient
	private String regionName;
	@Transient
	private String countryCode;
	@Transient
	private Integer month;

	public EclRunDetail() {

	}

	public EclRunDetail(Integer id, String idType, String name, String regionName, String countryCode,
			Integer regulationId) {
		this.id = id;
		this.idType = idType;
		this.name = name;
		this.regionName = regionName;
		this.countryCode = countryCode;
		this.fromDate = Date.valueOf(LocalDate.now());
		this.regulationId = regulationId;
	}

	public Integer getRunDetailId() {
		return runDetailId;
	}

	public void setRunDetailId(Integer runDetailId) {
		this.runDetailId = runDetailId;
	}

	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	public Integer getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(Integer regulationId) {
		this.regulationId = regulationId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getEcl() {
		return ecl;
	}

	public void setEcl(BigDecimal ecl) {
		this.ecl = ecl;
	}

	public BigDecimal getEcl12Month() {
		return ecl12Month;
	}

	public void setEcl12Month(BigDecimal ecl12Month) {
		this.ecl12Month = ecl12Month;
	}

	public BigDecimal getEclLongTerm() {
		return eclLongTerm;
	}

	public void setEclLongTerm(BigDecimal eclLongTerm) {
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

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
