package com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.assertions;

import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public final class WithdrawInquiryAssertions {

    private final WithdrawInquiry withdrawInquiry;

    private WithdrawInquiryAssertions(WithdrawInquiry withdrawInquiry) {
        this.withdrawInquiry = withdrawInquiry;
    }

    public static WithdrawInquiryAssertions assertThat_WithdrawInquiry(WithdrawInquiry withdrawInquiry) {
        return new WithdrawInquiryAssertions(withdrawInquiry);
    }

    public void allFieldsFilled_With(){
        assertThat(withdrawInquiry).isNotNull();
        assertThat(withdrawInquiry.getWithdrawValue()).isEqualTo(BigDecimal.valueOf(2650));
        assertThat(withdrawInquiry.getFgtsValue()).isEqualTo(BigDecimal.valueOf(10000));
        assertThat(withdrawInquiry.getFgtsValueAfterWithdraw()).isEqualTo(BigDecimal.valueOf(7350));
        assertThat(withdrawInquiry.getValueRange()).isEqualTo(BigDecimal.valueOf(2000));
    }
}