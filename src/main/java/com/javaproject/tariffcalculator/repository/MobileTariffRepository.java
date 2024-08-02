package com.javaproject.tariffcalculator.repository;

import com.javaproject.tariffcalculator.model.MobileTariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileTariffRepository extends JpaRepository<MobileTariff, String> {
    List<MobileTariff> findByMobileTariffData(int mobileTariffData);
    MobileTariff findMobileTariffNameByMobileTariffId(String id);
}
