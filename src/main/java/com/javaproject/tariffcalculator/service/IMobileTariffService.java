package com.javaproject.tariffcalculator.service;

import com.javaproject.tariffcalculator.dto.MobileTariffInsertDTO;
import com.javaproject.tariffcalculator.dto.MobileTariffUpdateDTO;
import com.javaproject.tariffcalculator.model.MobileTariff;
import com.javaproject.tariffcalculator.service.exception.EntityNotFoundException;

import java.util.List;

public interface IMobileTariffService {

    MobileTariff insertMobileTariff(MobileTariffInsertDTO dto) throws Exception;
    MobileTariff updateMobileTariff(MobileTariffUpdateDTO dto) throws EntityNotFoundException;
    MobileTariff deleteMobileTariff(String id) throws EntityNotFoundException;
    List<MobileTariff> getMobileTariffNameByMobileTariffData(int data) throws EntityNotFoundException;
    MobileTariff getByMobileTariffId(String id) throws EntityNotFoundException;
}
