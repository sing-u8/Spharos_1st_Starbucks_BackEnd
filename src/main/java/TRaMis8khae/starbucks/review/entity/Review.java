package TRaMis8khae.starbucks.review.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productUUID;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(length = 30)
    private String memberNickname;

    @Column(nullable = false, length = 50)
    private String reviewTitle;

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private Boolean reviewChecked; // 상품주문 테이블로

}