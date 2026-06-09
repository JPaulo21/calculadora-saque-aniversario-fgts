package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest //
class AnniversaryWithdrawalRangeRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    AnniversaryWithdrawalRangeRepository anniversaryWithdrawalRangeRepository;

    @Test
    void findByRange() {
        Optional<AnniversaryWithdrawalRange> sut = anniversaryWithdrawalRangeRepository
                .findByRange(BigDecimal.valueOf(18001));

        assertThat(sut.isPresent()).isTrue();
        assertThat(sut.get().getInitialRange()).isEqualTo(BigDecimal.valueOf(15000.01));
        assertThat(sut.get().getRangeLimit()).isEqualTo(BigDecimal.valueOf(20000.00).setScale(2));
        assertThat(sut.get().getRate()).isEqualTo(BigDecimal.valueOf(10).setScale(2));
        assertThat(sut.get().getFixedAdditionalAmount()).isEqualTo(BigDecimal.valueOf(1900).setScale(2));
    }

    @Test
    void findFirstByInitialRangeLessThanEqualAndRangeLimitGreaterThanEqual() {
        var valueFgts = BigDecimal.valueOf(18001);
        Optional<AnniversaryWithdrawalRange> sut = anniversaryWithdrawalRangeRepository
                .findFirstByInitialRangeLessThanEqualAndRangeLimitGreaterThanEqual(valueFgts, valueFgts);

        assertThat(sut.isPresent()).isTrue();
        assertThat(sut.get().getInitialRange()).isEqualTo(BigDecimal.valueOf(15000.01));
        assertThat(sut.get().getRangeLimit()).isEqualTo(BigDecimal.valueOf(20000.00).setScale(2));
        assertThat(sut.get().getRate()).isEqualTo(BigDecimal.valueOf(10).setScale(2));
        assertThat(sut.get().getFixedAdditionalAmount()).isEqualTo(BigDecimal.valueOf(1900).setScale(2));
    }
}