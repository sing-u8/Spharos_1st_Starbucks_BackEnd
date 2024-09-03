package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CouponOrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponOrderId;
    @Column(columnDefinition = "binary(16)")
    private String memberUUID;
    @Column(columnDefinition = "binary(16)")
    private String productUUID;
    private LocalDateTime registerDate;

    @ManyToOne
    private Coupon coupon;
}