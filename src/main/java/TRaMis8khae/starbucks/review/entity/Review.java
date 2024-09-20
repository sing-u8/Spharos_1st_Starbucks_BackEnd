package TRaMis8khae.starbucks.review.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productUUID;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private Long mediaID;

    @Builder
    public Review(String productUUID, String memberUUID, String memberMaskingId, String reviewContext, Integer reviewScore, Long mediaID) {
        this.productUUID = productUUID;
        this.memberUUID = memberUUID;
        this.memberMaskingId = memberMaskingId;
        this.reviewContext = reviewContext;
        this.reviewScore = reviewScore;
        this.mediaID = mediaID;
    }
}