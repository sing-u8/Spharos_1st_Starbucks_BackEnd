package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MobileVoucherOrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "binary(16)")
    private String memberUUID;
    @Column(columnDefinition = "binary(16)")
    private String productUUID;
    private LocalDateTime registerDate;
    private Double usedPrice;

    @ManyToOne
    private MobileVoucher mobileVoucher;
}
