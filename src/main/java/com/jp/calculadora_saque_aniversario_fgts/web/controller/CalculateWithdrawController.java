package com.jp.calculadora_saque_aniversario_fgts.web.controller;

import com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw.CalculateWithdrawService;
import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;
import com.jp.calculadora_saque_aniversario_fgts.web.docs.CalculateWitdrawDocs;
import com.jp.calculadora_saque_aniversario_fgts.web.dto.response.WithdrawResponseDTO;
import com.jp.calculadora_saque_aniversario_fgts.web.mapper.WithdrawInquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/calculate-withdraw", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
public class CalculateWithdrawController implements CalculateWitdrawDocs {

    private final CalculateWithdrawService calculateWithdrawService;

    @GetMapping
    public ResponseEntity<WithdrawResponseDTO> calculateWithdraw(@RequestParam("value") BigDecimal fgtsValue){
        WithdrawInquiry withdrawInquiry = calculateWithdrawService.calculateWithdraw(fgtsValue);
        WithdrawResponseDTO withdrawResponseDTO = WithdrawInquiryMapper.INSTANCE.toDTO(withdrawInquiry);
        return ResponseEntity.ok(withdrawResponseDTO);
    }
}
