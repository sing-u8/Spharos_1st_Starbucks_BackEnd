package TRaMis8khae.starbucks.review.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewUpdateResponseVo {

    private String reviewContext;

    private Integer reviewScore;

}