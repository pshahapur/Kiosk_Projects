package com.syne.asn.repository;

import java.util.List;
import java.util.Map;

import com.syne.asn.dto.InstrumentDto;
import com.syne.asn.dto.InstrumentMetaInfoDto;
import com.syne.asn.dto.InstrumentRegulationDto;

/*
 * @author subhajit
 */
public interface InstrumentSearchRepository {

	List<InstrumentDto> getInstruments(InstrumentDto instrumentDto);

	List<InstrumentDto> getAllInstruments();

	Map<Integer, InstrumentMetaInfoDto> getInstrumentByNameOrId(String name, Integer id);

	List<InstrumentRegulationDto> getInstrumentRegulationById(Integer instId);
}
