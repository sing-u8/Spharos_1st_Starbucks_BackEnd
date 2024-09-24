package TRaMis8khae.starbucks.voucher.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE member_voucher_list SET is_deleted = true WHERE id = ?")
public class MemberVoucherList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberUUID;

    private LocalDateTime registDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Voucher voucher;

    private boolean isDeleted = false;

    @Builder
    public MemberVoucherList(String memberUUID, LocalDateTime registDate, Voucher voucher) {
        this.memberUUID = memberUUID;
        this.registDate = registDate;
        this.voucher = voucher;
    }

}