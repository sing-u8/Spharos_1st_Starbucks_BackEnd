package TRaMis8khae.starbucks.review.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ReviewAddRequestVo {

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

}