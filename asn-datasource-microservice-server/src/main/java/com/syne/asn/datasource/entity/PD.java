package com.syne.asn.datasource.entity;

import java.io.Serializable;

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
@Table(name = "PD")
public class PD implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pdId;
	private String name;
	private Integer riskFactorId;
	private String moodyRatingMin;
	private String moodyRatingMax;
	private Integer month;
	private Double pdIfrs;
	private Double pdGaap;
	private Double pdBasel;
	private Double pdValue;

	public Integer getPdId() {
		return pdId;
	}

	public void setPdId(Integer pdId) {
		this.pdId = pdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRiskFactorId() {
		return riskFactorId;
	}

	public void setRiskFactorId(Integer riskFactorId) {
		this.riskFactorId = riskFactorId;
	}

	public String getMoodyRatingMin() {
		return moodyRatingMin;
	}

	public void setMoodyRatingMin(String moodyRatingMin) {
		this.moodyRatingMin = moodyRatingMin;
	}

	public String getMoodyRatingMax() {
		return moodyRatingMax;
	}

	public void setMoodyRatingMax(String moodyRatingMax) {
		this.moodyRatingMax = moodyRatingMax;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getPdIfrs() {
		return pdIfrs;
	}

	public void setPdIfrs(Double pdIfrs) {
		this.pdIfrs = pdIfrs;
	}

	public Double getPdGaap() {
		return pdGaap;
	}

	public void setPdGaap(Double pdGaap) {
		this.pdGaap = pdGaap;
	}

	public Double getPdBasel() {
		return pdBasel;
	}

	public void setPdBasel(Double pdBasel) {
		this.pdBasel = pdBasel;
	}

	public Double getPdValue() {
		return pdValue;
	}

	public void setPdValue(Double pdValue) {
		this.pdValue = pdValue;
	}
}