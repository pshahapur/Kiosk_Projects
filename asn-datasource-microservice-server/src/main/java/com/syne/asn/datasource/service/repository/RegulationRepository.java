package com.syne.asn.datasource.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syne.asn.datasource.entity.Regulation;

/*
 * @author subhajit
 */
@Transactional
public interface RegulationRepository extends JpaRepository<Regulation, Integer> {

}
