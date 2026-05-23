package com.jp.calculadora_saque_aniversario_fgts.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WithdrawResponseDTO {

    private String currencyUsed;
    private BigDecimal withdrawValue;
    private BigDecimal fgtsValueAfterWithdraw;
    private AnniversaryWithdrawalRangeResponseDTO range;
}
