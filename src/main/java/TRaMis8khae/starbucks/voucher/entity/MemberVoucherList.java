package TRaMis8khae.starbucks.voucher.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// 회원에 관련된 쿠폰인가, 상품에 관련된 쿠폰인가 등을 나눌 필요가 있는가?

@Entity
public class MemberVoucherList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "binary(16)")
    private String memberUUID;

    @Column(columnDefinition = "binary(16)")
    private String productUUID;

    private LocalDateTime registerDate;

    private Double usedPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Voucher voucher;
}
