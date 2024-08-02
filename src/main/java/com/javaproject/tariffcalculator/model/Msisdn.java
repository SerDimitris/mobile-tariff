package com.javaproject.tariffcalculator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "msisdns")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Msisdn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msisdnId;

    private int msisdnNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobiletariff_id", nullable = false)
    private MobileTariff mobileTariff;
}
