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
@Table(name = "LGDCoefficients")
public class LGDCoefficients implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lgdId;
	private String category;
	private Integer months;
	private Integer maturityMin;
	private Integer maturityMax;
	private String moodyRating;
	private Double lgdValue;
	private Double lgdIfrs;
	private Double lgdGaap;
	private Double lgdBasel;

	public Integer getLgdId() {
		return lgdId;
	}

	public void setLgdId(Integer lgdId) {
		this.lgdId = lgdId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Integer getMaturityMin() {
		return maturityMin;
	}

	public void setMaturityMin(Integer maturityMin) {
		this.maturityMin = maturityMin;
	}

	public Integer getMaturityMax() {
		return maturityMax;
	}

	public void setMaturityMax(Integer maturityMax) {
		this.maturityMax = maturityMax;
	}

	public String getMoodyRating() {
		return moodyRating;
	}

	public void setMoodyRating(String moodyRating) {
		this.moodyRating = moodyRating;
	}

	public Double getLgdValue() {
		return lgdValue;
	}

	public void setLgdValue(Double lgdValue) {
		this.lgdValue = lgdValue;
	}

	public Double getLgdIfrs() {
		return lgdIfrs;
	}

	public void setLgdIfrs(Double lgdIfrs) {
		this.lgdIfrs = lgdIfrs;
	}

	public Double getLgdGaap() {
		return lgdGaap;
	}

	public void setLgdGaap(Double lgdGaap) {
		this.lgdGaap = lgdGaap;
	}

	public Double getLgdBasel() {
		return lgdBasel;
	}

	public void setLgdBasel(Double lgdBasel) {
		this.lgdBasel = lgdBasel;
	}
}
