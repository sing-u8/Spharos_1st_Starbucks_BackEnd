package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Coupon {
    @Id
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
