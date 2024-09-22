package TRaMis8khae.starbucks.review.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewUpdateRequestVo {

    private String reviewContext;

    private Integer reviewScore;

}