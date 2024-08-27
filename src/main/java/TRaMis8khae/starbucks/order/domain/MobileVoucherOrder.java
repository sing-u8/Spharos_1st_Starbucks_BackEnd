package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class MobileVoucherOrder {
    @Id
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
