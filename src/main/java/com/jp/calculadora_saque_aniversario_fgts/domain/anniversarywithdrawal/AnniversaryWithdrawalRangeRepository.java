package com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnniversaryWithdrawalRangeRepository extends JpaRepository<AnniversaryWithdrawalRange, Long> {
}
