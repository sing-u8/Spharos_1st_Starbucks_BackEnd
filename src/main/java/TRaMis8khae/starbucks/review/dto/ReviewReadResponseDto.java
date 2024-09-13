package TRaMis8khae.starbucks.review.dto;

import TRaMis8khae.starbucks.review.vo.ReviewReadResponseVo;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewReadResponseDto {

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

    public ReviewReadResponseVo toVo() {
        return ReviewReadResponseVo.builder()
                .productUUID(this.productUUID)
                .memberUUID(this.memberUUID)
                .memberMaskingId(this.memberMaskingId)
                .memberNickname(this.memberNickname)
                .reviewTitle(this.reviewTitle)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .build();
    }

}