package com.jp.calculadora_saque_aniversario_fgts.web.mapper;

import com.jp.calculadora_saque_aniversario_fgts.web.dto.response.WithdrawResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.jp.calculadora_saque_aniversario_fgts.common.AnniversaryWithdrawalRangeConstants.anniversaryWithdrawalRange;
import static com.jp.calculadora_saque_aniversario_fgts.common.WithdrawInquiryConstants.WITHDRAW_INQUIRY;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class WithdrawInquiryMapperTest {

    @Test
    void mapToWithdrawInquiry() {
        WithdrawResponseDTO sut = WithdrawInquiryMapper.INSTANCE.toDTO(WITHDRAW_INQUIRY);

        assertThat(sut).isNotNull();
        assertThat(sut.getFgtsValueAfterWithdraw()).isEqualTo(WITHDRAW_INQUIRY.getFgtsValueAfterWithdraw());
        assertThat(sut.getCurrencyUsed()).isEqualTo("R$");
        assertThat(sut.getWithdrawValue()).isEqualTo(WITHDRAW_INQUIRY.getWithdrawValue());
        assertThat(sut.getRange()).isNotNull();
        assertThat(sut.getRange().initialRange()).isEqualTo(anniversaryWithdrawalRange.getInitialRange());
        assertThat(sut.getRange().rangeLimit()).isEqualTo(anniversaryWithdrawalRange.getRangeLimit());
        assertThat(sut.getRange().fixedAdditionalAmount()).isEqualTo(anniversaryWithdrawalRange.getFixedAdditionalAmount());
    }

}