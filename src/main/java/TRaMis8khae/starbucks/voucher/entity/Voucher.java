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
@SQLDelete(sql = "UPDATE voucher SET is_deleted = true WHERE id = ?")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private Double price;

    private String productUUID;

    private LocalDateTime expireDate;

    private String voucherCode;

    private boolean isDeleted = false;

    @Builder
    public Voucher(String name, Double price, String productUUID, LocalDateTime expireDate, String voucherCode) {
        this.name = name;
        this.price = price;
        this.productUUID = productUUID;
        this.expireDate = expireDate;
        this.voucherCode = voucherCode;
    }

}