package com.jp.calculadora_saque_aniversario_fgts.common;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;

import java.math.BigDecimal;

public class AnniversaryWithdrawalRangeConstants {
    public static final AnniversaryWithdrawalRange anniversaryWithdrawalRange = AnniversaryWithdrawalRange.builder()
            .id(1L)
            .initialRange(BigDecimal.valueOf(15000.01))
            .rangeLimit(BigDecimal.valueOf(20000))
            .fixedAdditionalAmount(BigDecimal.valueOf(1900))
            .rate(BigDecimal.TEN)
            .build();
}
