package com.syne.asn.datasource.service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.syne.asn.datasource.entity.InstrumentRegulation;

/*
 * @author subhajit
 */
@Transactional
public interface InstrumentRegulationRepository extends JpaRepository<InstrumentRegulation, Integer> {
	@Query("from InstrumentRegulation i where i.instrumentId = :instrumentId")
	List<InstrumentRegulation> getInstrumentRegulationById(@Param("instrumentId") Integer instrumentId);

	@Query("from InstrumentRegulation i where i.instrumentId = :instrumentId and i.regulationId = :regulationId")
	InstrumentRegulation getInstrumentRegulationByInstIdAndRegId(@Param("instrumentId") Integer instrumentId,
			@Param("regulationId") Integer regulationId);

	@Modifying(clearAutomatically = true)
	@Query("Update InstrumentRegulation i set riskProfileId = :riskProfileId where i.instrumentId = :instrumentId and i.regulationId = :regulationId")
	void updateInstrumentRegulation(@Param("riskProfileId") Integer riskProfileId,
			@Param("instrumentId") Integer instrumentId, @Param("regulationId") Integer regulationId);
}
