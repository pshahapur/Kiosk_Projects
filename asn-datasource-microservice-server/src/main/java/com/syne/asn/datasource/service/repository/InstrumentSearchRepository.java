package com.syne.asn.datasource.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.syne.asn.datasource.entity.Instrument;

/*
 * @author subhajit
 */
public interface InstrumentSearchRepository
		extends JpaRepository<Instrument, Integer>, InstrumentSearchRepositoryCustom {
	@Query("from Instrument i where i.name  like %:instrumentName%")
	List<Instrument> getInstrumentByName(@Param("instrumentName") String instrumentName);

	@Query("from Instrument i where i.instrumentId = :instrumentId")
	List<Instrument> getInstrumentById(@Param("instrumentId") Integer instrumentId);

}
