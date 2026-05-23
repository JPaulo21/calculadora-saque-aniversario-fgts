package com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.impl;

import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiryRepository;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WithdrawInquiryServiceImpl implements WithdrawInquiryService {

    private static final Logger log = LoggerFactory.getLogger(WithdrawInquiryServiceImpl.class);

    private final WithdrawInquiryRepository withdrawInquiryRepository;

    @Override
    @Transactional
    public WithdrawInquiry register(WithdrawInquiry withdrawInquiry) {
        WithdrawInquiry withdrawInquirySaved = withdrawInquiryRepository.save(withdrawInquiry);
        log.info("New withdrawal request registered. | Id: {}", withdrawInquirySaved.getId());
        return withdrawInquirySaved;
    }
}
