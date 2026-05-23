package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface AnniversaryWithdrawalRangeService {

    Page<AnniversaryWithdrawalRange> getRanges(Pageable pageable);

    AnniversaryWithdrawalRange getRangeByValue(BigDecimal value);
}
