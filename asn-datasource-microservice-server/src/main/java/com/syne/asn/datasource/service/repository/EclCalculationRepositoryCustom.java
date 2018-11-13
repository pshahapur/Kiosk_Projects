package com.syne.asn.datasource.service.repository;

import java.util.List;
import java.util.Map;

import com.syne.asn.datasource.dto.InstrumentDto;
import com.syne.asn.datasource.entity.EclRun;
import com.syne.asn.datasource.entity.EclRunDetail;

/*
 * @author subhajit
 */
public interface EclCalculationRepositoryCustom {

	List<EclRun> getInstrumentEclRun(InstrumentDto instDto);

	List<EclRun> getAccountEclRun(Integer accountId);

	List<EclRun> getOrganizationEclRun(Integer orgId);

	List<EclRun> getEclHistoryData(Integer id, String type, Integer regulationId, Map<Integer, Integer> regRiskMap);

	List<EclRunDetail> getEclSubHistoryData(Integer accountId, String type, Integer regulationId);

}
