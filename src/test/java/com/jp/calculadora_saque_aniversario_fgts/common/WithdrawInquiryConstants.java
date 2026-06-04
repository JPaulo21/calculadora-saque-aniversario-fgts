package com.jp.calculadora_saque_aniversario_fgts.common;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WithdrawInquiryConstants {

    public static final AnniversaryWithdrawalRange anniversaryWithdrawalRange = AnniversaryWithdrawalRange.builder()
            .initialRange(BigDecimal.valueOf(15000.01))
            .rangeLimit(BigDecimal.valueOf(20000))
            .fixedAdditionalAmount(BigDecimal.valueOf(1900))
            .id(1L)
            .build();

    public static final WithdrawInquiry withdrawInquiry = WithdrawInquiry.builder()
            .id(1L)
            .fgtsValue(BigDecimal.valueOf(15744.63))
            .anniversaryWithdrawalRange(anniversaryWithdrawalRange)
            .valueRange(BigDecimal.valueOf(1574.46))
            .withdrawValue(BigDecimal.valueOf(3474.46))
            .fgtsValueAfterWithdraw(BigDecimal.valueOf(12270.17))
            .createdAt(LocalDateTime.now())
            .build();
}
