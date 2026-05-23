package com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw.impl;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRangeService;
import com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw.CalculateWithdrawService;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculateWithdrawServiceImpl implements CalculateWithdrawService {

    private static final Logger log = LoggerFactory.getLogger(CalculateWithdrawServiceImpl.class);

    private final AnniversaryWithdrawalRangeService anniversaryWithdrawalRangeService;
    private final WithdrawInquiryService withdrawInquiryService;

    public WithdrawInquiry calculateWithdraw(BigDecimal fgtsValue){
        AnniversaryWithdrawalRange range = anniversaryWithdrawalRangeService.getRangeByValue(fgtsValue);
        log.info("Value: {} | Range: {}", fgtsValue, range);
        BigDecimal valuePercentage = fgtsValue
                .multiply(range.getRate())
                .divide(BigDecimal.valueOf(100L));
        BigDecimal withdrawValue = valuePercentage.add(range.getFixedAdditionalAmount());

        WithdrawInquiry withdrawInquiry = WithdrawInquiry.builder()
                .fgtsValue(fgtsValue)
                .anniversaryWithdrawalRange(range)
                .withdrawValue(withdrawValue)
                .valueRange(valuePercentage)
                .fgtsValueAfterWithdraw(fgtsValue.subtract(withdrawValue))
                .build();

        withdrawInquiryService.register(withdrawInquiry);

        return withdrawInquiry;
    }
}
