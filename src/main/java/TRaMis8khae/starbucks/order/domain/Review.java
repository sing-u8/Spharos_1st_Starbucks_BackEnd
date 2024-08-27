package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long productOrderId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    @Column(nullable = false, length = 50)
    private String loginId;
    private String memberMaskingId;
    @Column(length = 30)
    private String memberNickname;
    @Column(nullable = false, length = 50)
    private String reviewTitle;
    @Column(nullable = false, length = 50)
    private String reviewContext;
    private Integer reviewScore;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private Boolean reviewChecked;
}