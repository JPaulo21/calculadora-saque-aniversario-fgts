package com.jp.calculadora_saque_aniversario_fgts.web.controller.dto.response;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;

import java.math.BigDecimal;

public record AnniversaryWithdrawalRangeResponseDTO(
        BigDecimal initialRange,
        BigDecimal rangeLimit,
        BigDecimal rate,
        BigDecimal fixedAdditionalAmount
) {
    public static AnniversaryWithdrawalRangeResponseDTO toDTO(AnniversaryWithdrawalRange anniversaryWithdrawalRange) {
        return new AnniversaryWithdrawalRangeResponseDTO(
                anniversaryWithdrawalRange.getInitialRange(),
                anniversaryWithdrawalRange.getRangeLimit(),
                anniversaryWithdrawalRange.getRate(),
                anniversaryWithdrawalRange.getFixedAdditionalAmount()
        );
    }
}
