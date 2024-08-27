package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class MobileVoucherOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mobileGiftOrderId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private LocalDateTime registerDate;
    private Double usedPrice;

    @ManyToOne
    private MobileVoucher mobileVoucher;
}
