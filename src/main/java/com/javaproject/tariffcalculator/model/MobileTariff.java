package com.javaproject.tariffcalculator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "mobiletariff")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MobileTariff {
    @Id
    private String mobileTariffId;

    private String mobileTariffName;
    private String mobileTariffDescription;
    private double mobileTariffPrice;
    private int mobileTariffData;
    private int mobileTariffCalls;
    private int mobileTariffSms;

    @OneToMany(mappedBy = "mobileTariff", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Msisdn> msisdn;
}
