package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AnniversaryWithdrawalRangeRepository extends JpaRepository<AnniversaryWithdrawalRange, Long> {

    default AnniversaryWithdrawalRange findByRange(BigDecimal value){
        return findFirstByInitialRangeLessThanEqualAndRangeLimitGreaterThanEqual(value, value);
    };

    AnniversaryWithdrawalRange findFirstByInitialRangeLessThanEqualAndRangeLimitGreaterThanEqual(BigDecimal valueInitial, BigDecimal valueRangeLimit);
}
