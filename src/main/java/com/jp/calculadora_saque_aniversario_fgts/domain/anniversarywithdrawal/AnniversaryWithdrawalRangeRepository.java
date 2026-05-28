package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface AnniversaryWithdrawalRangeRepository extends JpaRepository<AnniversaryWithdrawalRange, Long> {

    default Optional<AnniversaryWithdrawalRange> findByRange(BigDecimal value){
        return findFirstByInitialRangeLessThanEqualAndRangeLimitGreaterThanEqual(value, value);
    };

    Optional<AnniversaryWithdrawalRange> findFirstByInitialRangeLessThanEqualAndRangeLimitGreaterThanEqual(BigDecimal valueInitial, BigDecimal valueRangeLimit);
}
