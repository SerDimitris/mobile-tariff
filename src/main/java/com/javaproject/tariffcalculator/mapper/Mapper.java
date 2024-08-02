package com.javaproject.tariffcalculator.mapper;

import com.javaproject.tariffcalculator.dto.*;
import com.javaproject.tariffcalculator.model.MobileTariff;
import com.javaproject.tariffcalculator.model.Msisdn;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    private Mapper() {}

    public static MobileTariff mapToMobileTariffInsertDTO(MobileTariffInsertDTO dto) {

        List<Msisdn> msisdns = dto.getMsisdn().stream()
                .map(Mapper::mapToMsisdnInsertDTO)
                .collect(Collectors.toList());

        MobileTariff mobileTariff = new MobileTariff(
            dto.getMobileTariffId(),
            dto.getMobileTariffName(),
            dto.getMobileTariffDescription(),
            dto.getMobileTariffPrice(),
            dto.getMobileTariffData(),
            dto.getMobileTariffCalls(),
            dto.getMobileTariffSms(),
                msisdns
        );
        msisdns.forEach(msisdn -> msisdn.setMobileTariff(mobileTariff));
        return mobileTariff;
    }

    public static MobileTariff mapToMobileTariffUpdateDTO(MobileTariffUpdateDTO dto) {

        List<Msisdn> msisdns = dto.getMsisdnUpdateDTOList().stream()
                .map(Mapper::mapToMsisdnUpdateDTO)
                .collect(Collectors.toList());
        MobileTariff mobileTariff = new MobileTariff(
                dto.getMobileTariffId(),
                dto.getMobileTariffName(),
                dto.getMobileTariffDescription(),
                dto.getMobileTariffPrice(),
                dto.getMobileTariffData(),
                dto.getMobileTariffCalls(),
                dto.getMobileTariffSms(),
                msisdns
        );
        msisdns.forEach(msisdn -> msisdn.setMobileTariff(mobileTariff));
        return mobileTariff;
    }

    public static MobileTariffReadOnlyDTO mapToMobileTariffReadOnlyDTO(MobileTariff mobileTariffReadOnlyDTO) {

        List<MsisdnReadOnlyDTO> msisdnDTOs = mobileTariffReadOnlyDTO.getMsisdn().stream()
                .map(Mapper::mapToReadOnlyDTO)
                .collect(Collectors.toList());

        return new MobileTariffReadOnlyDTO(mobileTariffReadOnlyDTO.getMobileTariffId(), mobileTariffReadOnlyDTO.getMobileTariffName(),
                mobileTariffReadOnlyDTO.getMobileTariffDescription(), mobileTariffReadOnlyDTO.getMobileTariffPrice(),
                mobileTariffReadOnlyDTO.getMobileTariffData(), mobileTariffReadOnlyDTO.getMobileTariffCalls(),
                mobileTariffReadOnlyDTO.getMobileTariffSms(), msisdnDTOs);
    }

    public static Msisdn mapToMsisdnInsertDTO(MsisdnInsertDTO dto) {
        Msisdn msisdn = new Msisdn(
                null,
                dto.getMsisdnNumber(),
                dto.getMobileTariff()
        );
        return msisdn;
    }

    public static Msisdn mapToMsisdnUpdateDTO(MsisdnUpdateDTO dto) {
        Msisdn msisdn = new Msisdn(
                null,
                dto.getMsisdnNumber(),
                dto.getMobileTariff()
        );
        return msisdn;
    }

    public static MsisdnReadOnlyDTO mapToReadOnlyDTO(Msisdn msisdn) {
        if (msisdn == null) return null;
        return new MsisdnReadOnlyDTO(
                msisdn.getMsisdnId(),
                msisdn.getMsisdnNumber(),
                msisdn.getMobileTariff()
        );
    }
}
