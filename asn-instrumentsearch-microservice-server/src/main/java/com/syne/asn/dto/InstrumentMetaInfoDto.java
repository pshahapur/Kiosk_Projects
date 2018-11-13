package com.syne.asn.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * @author subhajit
 */
public class InstrumentMetaInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String identifierType;
	private String category;
	private String subCategory;
	private String moodyRating;
	private String spRating;
	private String paymentFrequency;
	private Date maturityDate;
	private Double couponRate;
	private byte callable;
	private String regionName;
	private String state;
	private Integer regulationId;
	private Integer riskrPofileId;
	private String industryGroup;
	private String industrySubGroup;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
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

	public byte getCallable() {
		return callable;
	}

	public void setCallable(byte callable) {
		this.callable = callable;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getRegulationId() {
		return regulationId;
	}

	public void setRegulationId(Integer regulationId) {
		this.regulationId = regulationId;
	}

	public Integer getRiskrPofileId() {
		return riskrPofileId;
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

	public void setRiskrPofileId(Integer riskrPofileId) {
		this.riskrPofileId = riskrPofileId;
	}
}