package com.jp.calculadora_saque_aniversario_fgts.web.controller;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.impl.AnniversaryWithdrawalRangeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.jp.calculadora_saque_aniversario_fgts.common.AnniversaryWithdrawalRangeConstants.anniversaryWithdrawalRange;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnniversaryWithdrawalRangeController.class)
class AnniversaryWithdrawalRangeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    AnniversaryWithdrawalRangeServiceImpl anniversaryWithdrawalRangeService;

    @Test
    void getRangesWithdraw_returnRangesPageable() throws Exception {
        Pageable pageable = PageRequest.of(0, 10);
        var list = List.of(anniversaryWithdrawalRange);
        when(anniversaryWithdrawalRangeService.getRanges(any(Pageable.class)))
                .thenReturn(new PageImpl<AnniversaryWithdrawalRange>(list, pageable, 1));

        mockMvc.perform(get("/table")
                .accept(APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content.length()").value(list.size()))
                .andExpect(jsonPath("$.content[0].fixedAdditionalAmount").value(1900))
                .andExpect(jsonPath("$.page.number").value(0))
                .andExpect(jsonPath("$.page.totalElements").value(list.size()));
    }


    /*
    * Campo                 Descrição
    * $.content             Lista de elementos
    * $.totalElements       Total de registros
    * $.totalPages          Total de páginas
    * $.size                Tamanho da página
    * $.number              Página atual (0-based)
    * $.first               Se é a primeira página
    * $.last                Se é a última página
    * $.empty               Se não tem conteúdo
    * $.numberOfElements    Qtd de elementos na página atual
    * */
}