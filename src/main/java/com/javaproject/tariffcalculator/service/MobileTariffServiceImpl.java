package com.javaproject.tariffcalculator.service;

import com.javaproject.tariffcalculator.dto.MobileTariffInsertDTO;
import com.javaproject.tariffcalculator.dto.MobileTariffUpdateDTO;
import com.javaproject.tariffcalculator.dto.MsisdnInsertDTO;
import com.javaproject.tariffcalculator.mapper.Mapper;
import com.javaproject.tariffcalculator.model.MobileTariff;
import com.javaproject.tariffcalculator.model.Msisdn;
import com.javaproject.tariffcalculator.repository.MobileTariffRepository;
import com.javaproject.tariffcalculator.repository.MsisdnRepository;
import com.javaproject.tariffcalculator.service.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class MobileTariffServiceImpl implements IMobileTariffService{

    private final MobileTariffRepository mobileTariffRepository;
    private final MsisdnRepository msisdnRepository;

    @Transactional
    @Override
    public MobileTariff insertMobileTariff(MobileTariffInsertDTO dto) throws Exception {
        MobileTariff mobileTariff = null;

        try {
            mobileTariff = mobileTariffRepository.save(Mapper.mapToMobileTariffInsertDTO(dto));
            if(mobileTariff.getMobileTariffId() == null) throw new Exception("Insert error");

//            for (MsisdnInsertDTO msisdnDTO : dto.getMsisdn()) {
//                Msisdn msisdn = msisdnRepository.findByMsisdnId(Long.valueOf(dto.getMobileTariffId()));
//
//                if (msisdn != null) {
//                    msisdn.setMobileTariff(mobileTariff);
//                    msisdnRepository.save(msisdn);
//                } else {
//                    log.warn("MSISDN with id " + msisdn.getMsisdnId() + " not found");
//                }
//            }
            log.info("Insert new mobile tariff with id " + mobileTariff.getMobileTariffId() + " was success");

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
        return mobileTariff;
    }
    @Transactional
    @Override
    public MobileTariff updateMobileTariff(MobileTariffUpdateDTO dto) throws EntityNotFoundException {
        MobileTariff mobileTariff;
        MobileTariff updateMobileTariff;

        try {
            mobileTariff = mobileTariffRepository.findMobileTariffNameByMobileTariffId(dto.getMobileTariffId());
            if (mobileTariff == null) throw new EntityNotFoundException(MobileTariff.class, dto.getMobileTariffId());
            updateMobileTariff = mobileTariffRepository.save(Mapper.mapToMobileTariffUpdateDTO(dto));
            log.info("Mobile tariff with id: " + updateMobileTariff.getMobileTariffId() + " was updated.");
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            throw e;
        }
        return updateMobileTariff;
    }

    @Override
    public MobileTariff deleteMobileTariff(String id) throws EntityNotFoundException {
        MobileTariff mobileTariff = null;

        try {
            mobileTariff = mobileTariffRepository.findMobileTariffNameByMobileTariffId(id);
            if (mobileTariff == null) throw new EntityNotFoundException(MobileTariff.class, id);
            mobileTariffRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            throw e;
        }
        return mobileTariff;
    }

    @Override
    public List<MobileTariff> getMobileTariffNameByMobileTariffData(int data) throws EntityNotFoundException {
        List<MobileTariff> mobileTariffs = new ArrayList<>();

        try {
            mobileTariffs = mobileTariffRepository.findByMobileTariffData(data);
            if (mobileTariffs.isEmpty()) throw new EntityNotFoundException(MobileTariff.class, "0");
            log.info("Mobile tariffs with data " + data + " were found.");
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            throw e;
        }
        return mobileTariffs;
    }

    @Override
    public MobileTariff getByMobileTariffId(String id) throws EntityNotFoundException {
        MobileTariff mobileTariff;

        try {
            mobileTariff = mobileTariffRepository.findMobileTariffNameByMobileTariffId(id);
            if (mobileTariff == null) throw new EntityNotFoundException(MobileTariff.class, id);
            log.info("Mobile tariff with id " + id + "was found.");
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            throw e;
        }
        return mobileTariff;
    }
}
