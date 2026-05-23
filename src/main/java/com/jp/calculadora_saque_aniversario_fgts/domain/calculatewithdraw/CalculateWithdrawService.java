package com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw;

import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;
import com.jp.calculadora_saque_aniversario_fgts.web.dto.response.WithdrawResponseDTO;

import java.math.BigDecimal;

public interface CalculateWithdrawService {

    WithdrawInquiry calculateWithdraw(BigDecimal fgtsValue);
}
