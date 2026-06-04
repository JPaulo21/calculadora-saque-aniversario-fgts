package com.jp.calculadora_saque_aniversario_fgts.web.controller;

import com.jp.calculadora_saque_aniversario_fgts.domain.calculatewithdraw.impl.CalculateWithdrawServiceImpl;
import com.jp.calculadora_saque_aniversario_fgts.web.dto.response.WithdrawResponseDTO;
import com.jp.calculadora_saque_aniversario_fgts.web.mapper.WithdrawInquiryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static com.jp.calculadora_saque_aniversario_fgts.common.WithdrawInquiryConstants.withdrawInquiry;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers=CalculateWithdrawController.class)
@Import(WithdrawInquiryMapper.class)
class CalculateWithdrawControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    WithdrawInquiryMapper withdrawInquiryMapper;

    @MockitoBean
    CalculateWithdrawServiceImpl calculateWithdrawServiceImpl;

    @Test
    void calculateWithdraw_withDataValid_returnsWithdrawResponseDTO() throws Exception {
        when(calculateWithdrawServiceImpl.calculateWithdraw(any(BigDecimal.class)))
                .thenReturn(withdrawInquiry);
        when(withdrawInquiryMapper.toDTO(withdrawInquiry))
                .thenReturn(new WithdrawResponseDTO());

        mockMvc.perform(get("/calculate-withdraw")
                .param("value", "2100"))
                .andExpect(status().is2xxSuccessful());
    }

}