package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.impl;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRangeRepository;
import com.jp.calculadora_saque_aniversario_fgts.infra.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnniversaryWithdrawalRangeServiceImplTest {

    @Mock
    private AnniversaryWithdrawalRangeRepository anniversaryWithdrawalRangeRepository;

    @InjectMocks
    private AnniversaryWithdrawalRangeServiceImpl anniversaryWithdrawalRangeService;

    @BeforeEach
    void setUp() { }

    @Test
    void getRangeByValue_withValidData_returnsWithdrawalRange() {
        ArgumentMatcher<BigDecimal> isPositive = value -> value.compareTo(BigDecimal.ZERO) > 0;

        when(anniversaryWithdrawalRangeRepository.findByRange(argThat(isPositive)))
                .thenReturn(Optional.of(new AnniversaryWithdrawalRange()));

        AnniversaryWithdrawalRange sut = anniversaryWithdrawalRangeService.getRangeByValue(BigDecimal.valueOf(500));

        assertThat(sut).isNotNull();
    }

    @Test
    void getRangeByValue_withInvalidData_throwsBusinessException() {
        when(anniversaryWithdrawalRangeRepository.findByRange(any(BigDecimal.class)))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> anniversaryWithdrawalRangeService.getRangeByValue(BigDecimal.valueOf(-500)))
                .hasMessage("Invalid range: " + -500)
                .isInstanceOf(BusinessException.class);
    }

    @Test
    void getRanges_returnsPageAnniversaryWithdrawalRange(){
        var ranges = List.of(new AnniversaryWithdrawalRange());
        var pageable = PageRequest.of(0,1);

        when(anniversaryWithdrawalRangeRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(ranges, pageable, ranges.size()));

        Page<AnniversaryWithdrawalRange> sut = anniversaryWithdrawalRangeService.getRanges(pageable);

        assertThat(sut).isNotNull();
        assertThat(sut.hasContent()).isTrue();
        assertThat(sut.getContent()).hasSize(ranges.size());
        assertThat(sut.getTotalElements()).isEqualTo(ranges.size());
        assertThat(sut.getPageable().getPageNumber()).isEqualTo(0);
    }
}