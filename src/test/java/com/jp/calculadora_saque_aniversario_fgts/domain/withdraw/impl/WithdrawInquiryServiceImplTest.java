package com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.impl;

import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static com.jp.calculadora_saque_aniversario_fgts.common.WithdrawInquiryConstants.withdrawInquiry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class WithdrawInquiryServiceImplTest {

    @Mock
    private WithdrawInquiryRepository withdrawInquiryRepository;

    @InjectMocks
    private WithdrawInquiryServiceImpl withdrawInquiryService;

    @BeforeEach // para cada teste, esse méthodo é executado antes
    void setUp() {

    }

    @Test
    @DisplayName("Register Withdraw Inquiry With Valid Data Returns Withdraw Inquiry")
    void registerWithdrawInquiry_WithValidData_ReturnsWithdrawInquiry(){
        when(withdrawInquiryRepository.save(any(WithdrawInquiry.class)))
                .thenReturn(withdrawInquiry);

        WithdrawInquiry sut = withdrawInquiryService.register(new WithdrawInquiry());

        assertThat(sut.getValueRange()).isEqualTo(BigDecimal.valueOf(1574.46));
    }
}
