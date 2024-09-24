package TRaMis8khae.starbucks.review.dto.in;

import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.vo.in.ReviewUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewUpdateRequestDto {

    private String reviewUUID;

    private String reviewTitle;

    private String reviewContext;

    private Integer reviewScore;

    public static ReviewUpdateRequestDto toDto(ReviewUpdateRequestVo vo, String reviewUUID) {
        return ReviewUpdateRequestDto.builder()
                .reviewUUID(reviewUUID)
                .reviewContext(vo.getReviewContext())
                .reviewScore(vo.getReviewScore())
                .build();
    }

    public Review toUpdatedEntity(Review review) {
        return Review.builder()
                .id(review.getId())
                .memberMaskingId(review.getMemberMaskingId())
                .memberUUID(review.getMemberUUID())
                .productUUID(review.getProductUUID())
                .reviewUUID(this.reviewUUID)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .build();
    }

}