package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;
    @Column(nullable = false, length = 50)
    private String couponTitle;
    private String couponCode;
    @Column(length = 20)
    private String discountType;
    private Integer discount;
    private String couponType;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String condition;
}
