package TRaMis8khae.starbucks.coupon.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MemberCouponList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberUUID;

    private String productUUID;

    private LocalDateTime registerDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Coupon coupon;

}