package com.syne.asn.respository;

import com.syne.asn.dto.InstrumentRegulationDto;
import com.syne.asn.dto.RegulationDto;

/*
 * @author subhajit
 */
public interface RegulationRepository {

	RegulationDto getRegulationById(int regId);

	void updateInstrumentRegulation(InstrumentRegulationDto insRegDto);

}
