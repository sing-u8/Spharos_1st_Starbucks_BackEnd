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
                .reviewTitle(vo.getReviewTitle())
                .reviewContext(vo.getReviewContext())
                .reviewScore(vo.getReviewScore())
                .build();
    }

//    toEntity(Entity)
    public Review toEntity(Review review) {
        return Review.builder()
                .memberMaskingId(review.getMemberMaskingId())
                .memberNickname(review.getMemberNickname())
                .memberUUID(review.getMemberUUID())
                .productUUID(review.getProductUUID())
                .reviewTitle(this.reviewTitle)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .build();
    }

}