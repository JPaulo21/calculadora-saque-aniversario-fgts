package com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw.impl;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRangeService;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.assertions.WithdrawInquiryAssertions.assertThat_WithdrawInquiry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateWithdrawServiceImplTest {

    @Mock
    private AnniversaryWithdrawalRangeService anniversaryWithdrawalRangeService;

    @Mock
    private WithdrawInquiryService withdrawInquiryService;

    @InjectMocks
    private CalculateWithdrawServiceImpl calculateWithdrawService;

    @Test
    void calculateWithdraw_WithValidData_returnsWithdrawInquiry() {
        ArgumentMatcher<BigDecimal> isPositive = value -> value.compareTo(BigDecimal.ZERO) > 0;
        var rate = BigDecimal.valueOf(20);
        var valorDeConsulta = BigDecimal.valueOf(10000);

        AnniversaryWithdrawalRange range = AnniversaryWithdrawalRange.builder()
                .initialRange(BigDecimal.valueOf(5000.01))
                .rangeLimit(BigDecimal.valueOf(10000))
                .fixedAdditionalAmount(BigDecimal.valueOf(650))
                .rate(rate)
                .build();

        when(anniversaryWithdrawalRangeService.getRangeByValue(argThat(isPositive)))
                .thenReturn(range);

        WithdrawInquiry sut = calculateWithdrawService.calculateWithdraw(valorDeConsulta);

        verify(withdrawInquiryService).register(any(WithdrawInquiry.class));
        assertThat_WithdrawInquiry(sut).allFieldsFilled_With();
    }
}