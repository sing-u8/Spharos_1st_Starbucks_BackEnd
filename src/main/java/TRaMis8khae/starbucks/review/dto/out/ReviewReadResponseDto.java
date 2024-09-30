package TRaMis8khae.starbucks.review.dto.out;

import TRaMis8khae.starbucks.review.vo.out.ReviewReadResponseVo;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ReviewReadResponseDto {

    private Long reviewId;

    private String productUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private LocalDateTime updatedAt;

    @Setter
    private List<Long> mediaIdList;

    @Builder
    public ReviewReadResponseDto(Long reviewId, String productUUID, String memberMaskingId, String reviewContext, Integer reviewScore, LocalDateTime updatedAt) {
        this.reviewId = reviewId;
        this.productUUID = productUUID;
        this.memberMaskingId = memberMaskingId;
        this.reviewContext = reviewContext;
        this.reviewScore = reviewScore;
        this.updatedAt = updatedAt;
    }

    public ReviewReadResponseVo toVo() {
        return ReviewReadResponseVo.builder()
                .productUUID(this.productUUID)
                .updatedAt(this.updatedAt)
                .memberMaskingId(this.memberMaskingId)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .mediaIdList(this.mediaIdList)
                .build();
    }
}