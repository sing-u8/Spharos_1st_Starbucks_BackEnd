package TRaMis8khae.starbucks.review.vo.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewUpdateRequestVo {

    private String reviewContext;

    private Integer reviewScore;

}