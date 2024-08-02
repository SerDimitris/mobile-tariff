package com.javaproject.tariffcalculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public abstract class MsisdnBaseDTO {
    @NotNull
    private Long msisdnId;
}
