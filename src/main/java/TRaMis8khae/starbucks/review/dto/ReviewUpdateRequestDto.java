package TRaMis8khae.starbucks.review.dto;

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

}