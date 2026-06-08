package com.jp.calculadora_saque_aniversario_fgts.common;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.jp.calculadora_saque_aniversario_fgts.common.AnniversaryWithdrawalRangeConstants.anniversaryWithdrawalRange;

public class WithdrawInquiryConstants {

    public static final WithdrawInquiry WITHDRAW_INQUIRY = WithdrawInquiry.builder()
            .id(1L)
            .fgtsValue(BigDecimal.valueOf(15744.63))
            .anniversaryWithdrawalRange(anniversaryWithdrawalRange)
            .valueRange(BigDecimal.valueOf(1574.46))
            .withdrawValue(BigDecimal.valueOf(3474.46))
            .fgtsValueAfterWithdraw(BigDecimal.valueOf(12270.17))
            .createdAt(LocalDateTime.now())
            .build();
}
