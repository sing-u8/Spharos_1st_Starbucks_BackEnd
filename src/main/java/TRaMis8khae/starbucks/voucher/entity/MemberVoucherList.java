package TRaMis8khae.starbucks.voucher.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 회원에 관련된 쿠폰인가, 상품에 관련된 쿠폰인가 등을 나눌 필요가 있는가?

@Entity
@NoArgsConstructor
@Getter
public class MemberVoucherList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "binary(16)")
    private String memberUUID;

    private LocalDateTime registDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Voucher voucher;

    @Builder
    public MemberVoucherList(String memberUUID, LocalDateTime registDate, Voucher voucher) {
        this.memberUUID = memberUUID;
        this.registDate = registDate;
        this.voucher = voucher;
    }
}