package com.jp.calculadora_saque_aniversario_fgts.domain.withdraw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawInquiryRepository extends JpaRepository<WithdrawInquiry, Long> {
}
