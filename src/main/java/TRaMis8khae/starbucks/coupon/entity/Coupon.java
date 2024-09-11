package TRaMis8khae.starbucks.coupon.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Coupon {

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

    private LocalDateTime startDateTime; // BaseEntity로 빼기

    private LocalDateTime endDateTime;

    @Column(name = "`condition`", length = 50)  // condition은 예약어이므로 백틱으로 감싸줌
    private String condition; // 필요한가

//    private List<MemberCouponList> memberCouponList = new ArrayList<>();

}