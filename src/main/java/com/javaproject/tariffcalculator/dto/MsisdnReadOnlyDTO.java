package com.javaproject.tariffcalculator.dto;

import com.javaproject.tariffcalculator.model.MobileTariff;

public class MsisdnReadOnlyDTO extends MsisdnBaseDTO {
    private Long msisdnId;
    private int msisdnNumber;
    private MobileTariff mobileTariff;

    public MsisdnReadOnlyDTO(Long msisdnId, int msisdnNumber, MobileTariff mobileTariff) {
        setMsisdnId(msisdnId);
        this.msisdnNumber = msisdnNumber;
        this.mobileTariff = mobileTariff;
    }
}
