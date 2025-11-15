package com.jp.calculadora_saque_aniversario_fgts.web.controller;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRangeService;
import com.jp.calculadora_saque_aniversario_fgts.web.controller.docs.AnniversaryWithdrawalRangeDocs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
@RequiredArgsConstructor
public class AnniversaryWithdrawalRangeController implements AnniversaryWithdrawalRangeDocs {

    private final AnniversaryWithdrawalRangeService anniversaryWithdrawalRangeService;
}
