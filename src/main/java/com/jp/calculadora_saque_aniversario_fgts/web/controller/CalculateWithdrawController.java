package com.jp.calculadora_saque_aniversario_fgts.web.controller;

import com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw.CalculateWithdrawService;
import com.jp.calculadora_saque_aniversario_fgts.web.controller.docs.CalculateWitdrawDocs;
import com.jp.calculadora_saque_aniversario_fgts.web.controller.dto.response.WithdrawResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/calculate-withdraw", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CalculateWithdrawController implements CalculateWitdrawDocs {

    private final CalculateWithdrawService calculateWithdrawService;

    @GetMapping("/{value}")
    public ResponseEntity<WithdrawResponseDTO> calculateWithdraw(@PathVariable("value") BigDecimal fgtsValue){
        return ResponseEntity
                .ok(calculateWithdrawService.calculateWithdraw(fgtsValue));
    }
}
