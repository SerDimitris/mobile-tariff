package com.javaproject.tariffcalculator.dto;

import com.javaproject.tariffcalculator.model.Msisdn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MobileTariffInsertDTO {

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
    private List<MsisdnInsertDTO> msisdn;

}