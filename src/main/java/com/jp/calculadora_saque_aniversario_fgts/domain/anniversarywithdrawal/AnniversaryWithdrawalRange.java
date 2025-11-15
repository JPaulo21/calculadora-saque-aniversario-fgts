package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(schema = "withdraw", name = "anniversary_withdrawal_range")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AnniversaryWithdrawalRange {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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
