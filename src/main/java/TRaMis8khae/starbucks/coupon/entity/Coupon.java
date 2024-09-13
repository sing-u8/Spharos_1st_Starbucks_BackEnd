package TRaMis8khae.starbucks.coupon.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Coupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String couponTitle;

    private String couponCode;

    @Column(length = 20)
    private String discountType;

    private Integer discount;

    private String couponType; // 이건 뭐지

    private Integer atLeastPrice;

}