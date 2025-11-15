package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AnniversaryWithdrawalRangeService {

    private final AnniversaryWithdrawalRangeRepository anniversaryWithdrawalRangeRepository;

    public Page<AnniversaryWithdrawalRange> getRanges(Pageable pageable) {
        return anniversaryWithdrawalRangeRepository.findAll(pageable);
    }

    public AnniversaryWithdrawalRange getRangeByValue(BigDecimal value){
        return anniversaryWithdrawalRangeRepository.findByRange(value);
    }
}
