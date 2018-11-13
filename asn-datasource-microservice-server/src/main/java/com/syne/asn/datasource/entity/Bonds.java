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
@Table(name = "Bonds")
public class Bonds implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bondId;
	private String isin;
	private Integer instrumentTypeId;
	private String description;
	private String category;
	private String subCategory;
	private String industryGroup;
	private String industrySubGroup;
	private String currencyId;
	private Integer regionId;
	private String status;
	private Integer secured;
	private String moodyRating;
	private String spRating;
	private String fitchRating;
	private String paymentFrequency;
	private Date maturityDate;
	private Double couponRate;
	private Integer callable;
	private Double maturityAmount;
	private Double faceValue;
	private Double yield;
	private Double outstandingAmount;

	public Integer getBondId() {
		return bondId;
	}

	public void setBondId(Integer bondId) {
		this.bondId = bondId;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public Integer getInstrumentTypeId() {
		return instrumentTypeId;
	}

	public void setInstrumentTypeId(Integer instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getIndustryGroup() {
		return industryGroup;
	}

	public void setIndustryGroup(String industryGroup) {
		this.industryGroup = industryGroup;
	}

	public String getIndustrySubGroup() {
		return industrySubGroup;
	}

	public void setIndustrySubGroup(String industrySubGroup) {
		this.industrySubGroup = industrySubGroup;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSecured() {
		return secured;
	}

	public void setSecured(Integer secured) {
		this.secured = secured;
	}

	public String getMoodyRating() {
		return moodyRating;
	}

	public void setMoodyRating(String moodyRating) {
		this.moodyRating = moodyRating;
	}

	public String getSpRating() {
		return spRating;
	}

	public void setSpRating(String spRating) {
		this.spRating = spRating;
	}

	public String getFitchRating() {
		return fitchRating;
	}

	public void setFitchRating(String fitchRating) {
		this.fitchRating = fitchRating;
	}

	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Double getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(Double couponRate) {
		this.couponRate = couponRate;
	}

	public Integer getCallable() {
		return callable;
	}

	public void setCallable(Integer callable) {
		this.callable = callable;
	}

	public Double getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(Double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public Double getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Double faceValue) {
		this.faceValue = faceValue;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}
}
