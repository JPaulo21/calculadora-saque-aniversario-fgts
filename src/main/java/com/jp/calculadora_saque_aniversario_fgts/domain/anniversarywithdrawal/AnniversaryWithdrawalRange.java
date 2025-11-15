package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(schema = "withdraw", name = "anniversary_withdrawal_range")
public class AnniversaryWithdrawalRange {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_range", nullable = false)
    private BigDecimal initialRange;

    @Column(name = "range_limit", nullable = false)
    private BigDecimal rangeLimit;

    @Column(name = "rate", nullable = false)
    private BigDecimal rate;

    @Column(name = "fixed_additional_amount", nullable = false)
    private BigDecimal fixedAdditionalAmount;
}
