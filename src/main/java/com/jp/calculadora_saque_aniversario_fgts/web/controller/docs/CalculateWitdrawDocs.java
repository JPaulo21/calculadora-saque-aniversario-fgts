package com.jp.calculadora_saque_aniversario_fgts.web.controller.docs;

import com.jp.calculadora_saque_aniversario_fgts.web.controller.dto.response.WithdrawResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@Tag(name = "Calcular saque", description = "Calcular o valor de saque-aniversário")
public interface CalculateWitdrawDocs {

    @Operation(summary = "Calcaular valor do saque")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = WithdrawResponseDTO.class)))
    ResponseEntity<WithdrawResponseDTO> calculateWithdraw(BigDecimal fgtsValue);
}
