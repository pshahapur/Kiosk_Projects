package com.syne.asn.datasource.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

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
	private Integer callable;
	private String regionName;
	private String industryGroup;
	private String industrySubGroup;
	private String state;
	private Map<Integer, Integer> regulationMap;

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

	public Integer getCallable() {
		return callable;
	}

	public void setCallable(Integer callable) {
		this.callable = callable;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Map<Integer, Integer> getRegulationMap() {
		return regulationMap;
	}

	public void setRegulationMap(Map<Integer, Integer> regulationMap) {
		this.regulationMap = regulationMap;
	}

}