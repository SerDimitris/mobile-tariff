package com.javaproject.tariffcalculator.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class MobileTariffReadOnlyDTO {
    private String mobileTariffId;
    private String mobileTariffName;
    private String mobileTariffDescription;
    private double mobileTariffPrice;
    private int mobileTariffData;
    private int mobileTariffCalls;
    private int mobileTariffSms;
    private List<MsisdnReadOnlyDTO> msisdnReadOnlyDTOList;

    public MobileTariffReadOnlyDTO (String Id, String mobileTariffName, String mobileTariffDescription, double mobileTariffPrice,
                                    int mobileTariffData, int mobileTariffCalls, int mobileTariffSms, List<MsisdnReadOnlyDTO> msisdnReadOnlyDTOList) {

        setMobileTariffId(Id);
        this.mobileTariffName = mobileTariffName;
        this.mobileTariffDescription = mobileTariffDescription;
        this.mobileTariffPrice = mobileTariffPrice;
        this.mobileTariffData = mobileTariffData;
        this.mobileTariffCalls = mobileTariffCalls;
        this.mobileTariffSms = mobileTariffSms;
        this.msisdnReadOnlyDTOList = msisdnReadOnlyDTOList;


    }
}
