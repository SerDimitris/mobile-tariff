package com.javaproject.tariffcalculator.dto;

import com.javaproject.tariffcalculator.model.MobileTariff;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MsisdnUpdateDTO extends MsisdnBaseDTO {

    @NotNull
    @Size(min = 10, max = 10, message = "The number must be exactly 10 digits.")
    private int msisdnNumber;
    private MobileTariff mobileTariff;
}
