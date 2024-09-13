package TRaMis8khae.starbucks.review.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
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

    @Builder
    public Review(Long id, String productUUID, String memberUUID, String memberMaskingId, String memberNickname, String reviewTitle, String reviewContext, Integer reviewScore) {
        this.id = id;
        this.productUUID = productUUID;
        this.memberUUID = memberUUID;
        this.memberMaskingId = memberMaskingId;
        this.memberNickname = memberNickname;
        this.reviewTitle = reviewTitle;
        this.reviewContext = reviewContext;
        this.reviewScore = reviewScore;
    }

    public void updateReview(String reviewTitle, String reviewContext, Integer reviewScore) {
        this.reviewTitle = reviewTitle;
        this.reviewContext = reviewContext;
        this.reviewScore = reviewScore;
    }

}