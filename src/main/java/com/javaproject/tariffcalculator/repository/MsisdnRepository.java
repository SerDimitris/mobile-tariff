package com.javaproject.tariffcalculator.repository;

import com.javaproject.tariffcalculator.model.Msisdn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsisdnRepository extends JpaRepository<Msisdn, Long> {
    Msisdn findByMsisdnId(Long id);
}
