package com.syne.asn.datasource.service.repository;

import java.util.List;
import java.util.Map;

import com.syne.asn.datasource.dto.InstrumentMetaInfoDto;
import com.syne.asn.datasource.entity.Instrument;

/*
 * @author subhajit
 */
public interface InstrumentSearchRepositoryCustom {
	List<Instrument> getInstruments(Instrument instrument);

	Map<Integer, InstrumentMetaInfoDto> getInstrumentByNameAndId(String name, Integer id);

	List<Instrument> getAllInstruments();
}
