package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnniversaryWithdrawalRangeService {

    private final AnniversaryWithdrawalRangeRepository anniversaryWithdrawalRangeRepository;
}
