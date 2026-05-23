package com.jp.calculadora_saque_aniversario_fgts.web.mapper;

import com.jp.calculadora_saque_aniversario_fgts.domain.withdraw.WithdrawInquiry;
import com.jp.calculadora_saque_aniversario_fgts.web.dto.response.WithdrawResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WithdrawInquiryMapper {

    WithdrawInquiryMapper INSTANCE = Mappers.getMapper(WithdrawInquiryMapper.class);

    @Mapping(target = "currencyUsed", constant = "R$")
    @Mapping(target = "range", source = "anniversaryWithdrawalRange")
    WithdrawResponseDTO toDTO(WithdrawInquiry entity);
}
