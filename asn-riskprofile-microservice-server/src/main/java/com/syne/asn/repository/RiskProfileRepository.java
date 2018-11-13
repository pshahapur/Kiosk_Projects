package com.syne.asn.repository;

import java.util.List;

import com.syne.asn.dto.RiskProfileDto;

/*
 * @author subhajit
 */
public interface RiskProfileRepository {

	RiskProfileDto getRiskProfileById(int riskProfileId);

	void updateRiskProfile(int riskProfileId, RiskProfileDto riskProfileEntity);

	List<RiskProfileDto> getAllRiskProfile();

	RiskProfileDto createRiskProfile(RiskProfileDto riskProfileDto);

}
