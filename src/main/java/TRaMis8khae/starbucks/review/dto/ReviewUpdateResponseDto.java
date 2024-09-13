package TRaMis8khae.starbucks.review.dto;

import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewUpdateResponseDto {

    private String reviewTitle;

    private String reviewContext;

    private Integer reviewScore;

    public static ReviewUpdateResponseDto toDto(Review review) {
        return ReviewUpdateResponseDto.builder()
                .reviewTitle(review.getReviewTitle())
                .reviewContext(review.getReviewContext())
                .reviewScore(review.getReviewScore())
                .build();
    }

    public ReviewUpdateResponseVo toVo() {
        return ReviewUpdateResponseVo.builder()
                .reviewTitle(this.reviewTitle)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .build();
    }

}