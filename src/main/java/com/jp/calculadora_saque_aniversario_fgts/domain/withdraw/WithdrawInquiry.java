package com.jp.calculadora_saque_aniversario_fgts.domain.withdraw;

import com.jp.calculadora_saque_aniversario_fgts.domain.anniversarywithdrawal.AnniversaryWithdrawalRange;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(schema = "withdraw", name = "withdrawal_inquiry")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class WithdrawInquiry {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "fgts_value", nullable = false)
    private BigDecimal fgtsValue;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "anniversary_withdrawal_range_id",
            foreignKey = @ForeignKey(name = "FK_ANNIVERSARY_WITHDRAWAL_RANGE_ID"),
            nullable = false
    )
    private AnniversaryWithdrawalRange anniversaryWithdrawalRange;

    @Column(name = "withdraw_value", nullable = false)
    private BigDecimal withdrawValue;

    @Column(name = "value_range", nullable = false)
    private BigDecimal valueRange;

    @Column(name = "fgts_value_after_withdraw", nullable = false)
    private BigDecimal fgtsValueAfterWithdraw;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
