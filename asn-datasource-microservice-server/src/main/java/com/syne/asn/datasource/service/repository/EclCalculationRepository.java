package com.syne.asn.datasource.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syne.asn.datasource.entity.EclRun;

/*
 * @author subhajit
 */
public interface EclCalculationRepository extends JpaRepository<EclRun, Integer>, EclCalculationRepositoryCustom {
}
