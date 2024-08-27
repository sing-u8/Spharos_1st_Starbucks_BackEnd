package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CouponOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponOrderId;
    @Column(columnDefinition = "binary(16)")
    private UUID memverUuid;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private LocalDateTime registerDate;

    @ManyToOne
    private Coupon coupon;
}