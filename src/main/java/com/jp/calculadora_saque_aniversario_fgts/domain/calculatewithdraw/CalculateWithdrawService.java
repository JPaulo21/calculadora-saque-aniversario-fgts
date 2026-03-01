package com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRangeService;
import com.jp.calculadora_saque_aniversario_fgts.web.controller.dto.response.AnniversaryWithdrawalRangeResponseDTO;
import com.jp.calculadora_saque_aniversario_fgts.web.controller.dto.response.WithdrawResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CalculateWithdrawService {

    private static final Logger log = LoggerFactory.getLogger(CalculateWithdrawService.class);

    private final AnniversaryWithdrawalRangeService anniversaryWithdrawalRangeService;

    public WithdrawResponseDTO calculateWithdraw(BigDecimal fgtsValue){
        AnniversaryWithdrawalRange range = anniversaryWithdrawalRangeService.getRangeByValue(fgtsValue);
        log.info("Value: {} | Range: {}", fgtsValue, range);
        BigDecimal withdraw = fgtsValue
                .multiply(range.getRate())
                .divide(new BigDecimal("100"))
                .add(range.getFixedAdditionalAmount());
        BigDecimal fgtsValusAfterWithdraw = fgtsValue.subtract(withdraw);

        return WithdrawResponseDTO
                .builder()
                .currencyUsed(Currency.getInstance(Locale.of("pt", "BR")).getSymbol())
                .withdrawValue(withdraw)
                .fgtsValueAfterWithdraw(fgtsValusAfterWithdraw)
                .range(AnniversaryWithdrawalRangeResponseDTO.toDTO(range))
                .build();
    }
}
