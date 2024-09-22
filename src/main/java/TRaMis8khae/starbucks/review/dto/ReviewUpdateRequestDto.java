package TRaMis8khae.starbucks.review.dto;

import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewUpdateRequestDto {

    private String reviewTitle;

    private String reviewContext;

    private Integer reviewScore;

    public static ReviewUpdateRequestDto toDto(ReviewUpdateRequestVo vo) {
        return ReviewUpdateRequestDto.builder()
                .reviewContext(vo.getReviewContext())
                .reviewScore(vo.getReviewScore())
                .build();
    }

    public Review toEntity(Review review) {
        return Review.builder()
                .id(review.getId())
                .memberMaskingId(review.getMemberMaskingId())
                .memberUUID(review.getMemberUUID())
                .productUUID(review.getProductUUID())
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .build();
    }

}