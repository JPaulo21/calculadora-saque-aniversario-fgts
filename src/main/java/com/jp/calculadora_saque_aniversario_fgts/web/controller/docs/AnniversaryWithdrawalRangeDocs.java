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

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Tabela do saque-aniversário do FGTS", description = "A tabela organiza os saques por faixas de saldo")
public interface AnniversaryWithdrawalRangeDocs {

    @Operation(summary = "")
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(type = "string", example = """
                            {
                                  "initialRange": 0,
                                  "rangeLimit": 500,
                                  "rate": 50,
                                  "fixedAdditionalAmount": 0
                                },
                                {
                                  "initialRange": 500.01,
                                  "rangeLimit": 1000,
                                  "rate": 40,
                                  "fixedAdditionalAmount": 50
                                },
                                {
                                  "initialRange": 1000.01,
                                  "rangeLimit": 5000,
                                  "rate": 30,
                                  "fixedAdditionalAmount": 150
                                },
                                {
                                  "initialRange": 5000.01,
                                  "rangeLimit": 10000,
                                  "rate": 20,
                                  "fixedAdditionalAmount": 650
                                },
                                {
                                  "initialRange": 10000.01,
                                  "rangeLimit": 15000,
                                  "rate": 15,
                                  "fixedAdditionalAmount": 1150
                                },
                                {
                                  "initialRange": 15000.01,
                                  "rangeLimit": 20000,
                                  "rate": 10,
                                  "fixedAdditionalAmount": 1900
                                },
                                {
                                  "initialRange": 20000.01,
                                  "rangeLimit": 99999999,
                                  "rate": 5,
                                  "fixedAdditionalAmount": 2900
                                }
                            """)))
    ResponseEntity<Page<AnniversaryWithdrawalRangeResponseDTO>> getRanges(@PageableDefault Pageable pageable);
}
