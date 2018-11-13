package com.syne.asn.datasource.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
@Table(name = "ECLRun")
public class EclRun implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer runId;
	private String description;
	private Integer quantModelID;
	private Integer regulationId;
	private Integer id;
	private String idType;
	private String name;
	private Integer regionId;
	private BigDecimal ecl;
	private BigDecimal ecl12Month;
	private BigDecimal eclLongTerm;
	private Date fromDate;
	private Date toDate;
	private Integer riskProfileId;
	@Transient
	private String regionName;
	@Transient
	private String countryCode;
	@Transient
	List<EclRunDetail> eclRunDetailLst;
	@Transient
	private int month;

	public EclRun() {
	}

	public EclRun(Integer id, String name, Integer regulationId, String regType, BigDecimal ecl12Month,
			BigDecimal eclLongTerm, Integer regionId, String regionName, String countryCode, Integer riskProfileId) {
		this.id = id;
		this.name = name;
		this.regulationId = regulationId;
		this.idType = regType;
		this.ecl12Month = ecl12Month;
		this.eclLongTerm = eclLongTerm;
		this.regionId = regionId;
		this.regionName = regionName;
		this.countryCode = countryCode;
		this.fromDate = Date.valueOf(LocalDate.now());
		this.riskProfileId = riskProfileId;

	}

	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantModelID() {
		return quantModelID;
	}

	public void setQuantModelID(Integer quantModelID) {
		this.quantModelID = quantModelID;
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

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
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

	public Integer getRiskProfileId() {
		return riskProfileId;
	}

	public void setRiskProfileId(Integer riskProfileId) {
		this.riskProfileId = riskProfileId;
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

	public List<EclRunDetail> getEclRunDetailLst() {
		return eclRunDetailLst;
	}

	public void setEclRunDetailLst(List<EclRunDetail> eclRunDetailLst) {
		this.eclRunDetailLst = eclRunDetailLst;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}