package TRaMis8khae.starbucks.review.dto.out;

import TRaMis8khae.starbucks.review.vo.out.ReviewReadResponseVo;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReviewReadResponseDto {

    private String productUUID;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private List<Long> mediaIdList;

    public ReviewReadResponseVo toVo() {
        return ReviewReadResponseVo.builder()
                .productUUID(this.productUUID)
                .memberUUID(this.memberUUID)
                .memberMaskingId(this.memberMaskingId)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .mediaIdList(this.mediaIdList)
                .build();
    }

}