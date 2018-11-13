package com.syne.asn.datasource.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.syne.asn.datasource.entity.RiskProfile;

/*
 * @author subhajit
 */
@Transactional
public interface RiskProfileRepository extends JpaRepository<RiskProfile, Integer> {
	@Modifying(clearAutomatically = true)
	@Query("update RiskProfile r set r.riskFactors = :riskFactors where r.riskProfileId = :riskProfileId")
	void updateRiskProfile(@Param("riskProfileId") Integer riskProfileId, @Param("riskFactors") String riskFactors);

}
