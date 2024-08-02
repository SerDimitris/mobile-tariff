package com.javaproject.tariffcalculator.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MobileTariffUpdateDTO {

    @NotNull
    @Size(min = 3, max = 16)
    private String mobileTariffId;
    @NotNull
    @Size(min = 3, max = 30, message = "Tariff name must be least 3 characters.")
    private String mobileTariffName;
    private String mobileTariffDescription;
    @NotNull
    private double mobileTariffPrice;
    private int mobileTariffData;
    private int mobileTariffCalls;
    private int mobileTariffSms;
    private List<MsisdnUpdateDTO> msisdnUpdateDTOList;
}
