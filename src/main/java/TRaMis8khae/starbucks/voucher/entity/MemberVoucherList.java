package TRaMis8khae.starbucks.voucher.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class MemberVoucherList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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