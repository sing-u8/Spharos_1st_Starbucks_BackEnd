package TRaMis8khae.starbucks.voucher.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
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

    @Builder
    public Voucher(String name, Double price, String productUUID, LocalDateTime expireDate, String voucherCode) {
        this.name = name;
        this.price = price;
        this.productUUID = productUUID;
        this.expireDate = expireDate;
        this.voucherCode = voucherCode;
    }

}