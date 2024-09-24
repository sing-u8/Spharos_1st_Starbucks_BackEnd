package TRaMis8khae.starbucks.review.dto.in;

import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.vo.in.ReviewAddRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
public class ReviewAddRequestDto {

    private String reviewUUID;

    private String productUUID;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private List<Long> mediaList;

    private LocalDateTime registDate;

    public static ReviewAddRequestDto toDto(ReviewAddRequestVo vo, String memberUUID, String reviewUUID) {
        return ReviewAddRequestDto.builder()
                .reviewUUID(reviewUUID)
                .productUUID(vo.getProductUUID())
                .memberUUID(memberUUID)
                .memberMaskingId(vo.getMemberMaskingId())
                .reviewContext(vo.getReviewContext())
                .reviewScore(vo.getReviewScore())
                .registDate(vo.getRegistDate())
                .build();
    }

    public Review toEntity() {
        return Review.builder()
                .reviewUUID(this.reviewUUID)
                .productUUID(this.productUUID)
                .memberUUID(this.memberUUID)
                .memberMaskingId(this.memberMaskingId)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .build();
    }

}