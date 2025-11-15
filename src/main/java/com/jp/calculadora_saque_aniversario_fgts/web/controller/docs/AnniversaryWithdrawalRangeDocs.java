package com.jp.calculadora_saque_aniversario_fgts.web.controller.docs;

import com.jp.calculadora_saque_aniversario_fgts.web.controller.dto.response.AnniversaryWithdrawalRangeResponseDTO;
import com.jp.calculadora_saque_aniversario_fgts.web.controller.dto.response.WithdrawResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

@Tag(name = "Tabela do saque-aniversário do FGTS", description = "A tabela organiza os saques por faixas de saldo")
public interface AnniversaryWithdrawalRangeDocs {

    @Operation(summary = "")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AnniversaryWithdrawalRangeResponseDTO.class)))
    ResponseEntity<Page<AnniversaryWithdrawalRangeResponseDTO>> getRanges(@PageableDefault Pageable pageable);
}
