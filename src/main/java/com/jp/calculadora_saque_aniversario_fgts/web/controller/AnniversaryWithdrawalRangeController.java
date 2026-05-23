package com.jp.calculadora_saque_aniversario_fgts.web.controller;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.impl.AnniversaryWithdrawalRangeServiceImpl;
import com.jp.calculadora_saque_aniversario_fgts.web.docs.AnniversaryWithdrawalRangeDocs;
import com.jp.calculadora_saque_aniversario_fgts.web.dto.response.AnniversaryWithdrawalRangeResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/table", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AnniversaryWithdrawalRangeController implements AnniversaryWithdrawalRangeDocs {

    private final AnniversaryWithdrawalRangeServiceImpl anniversaryWithdrawalRangeServiceImpl;

    @GetMapping
    public ResponseEntity<Page<AnniversaryWithdrawalRangeResponseDTO>> getRanges(@PageableDefault @Schema(hidden = true) Pageable pageable){
        Page<AnniversaryWithdrawalRangeResponseDTO> anniversaryWithdrawalRangeDTOPage = anniversaryWithdrawalRangeServiceImpl
                .getRanges(pageable)
                .map(AnniversaryWithdrawalRangeResponseDTO::toDTO);
        return ResponseEntity.ok(anniversaryWithdrawalRangeDTOPage);
    }

}
