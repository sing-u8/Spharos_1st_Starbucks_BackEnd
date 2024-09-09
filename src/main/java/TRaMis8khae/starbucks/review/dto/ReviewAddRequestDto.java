package TRaMis8khae.starbucks.review.dto;

import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.vo.ReviewAddRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ReviewAddRequestDto {

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

    public static Review toEntity(ReviewAddRequestDto dto) {
        return Review.builder()
                .productUUID(dto.getProductUUID())
                .memberUUID(dto.getMemberUUID())
                .memberMaskingId(dto.getMemberMaskingId())
                .memberNickname(dto.getMemberNickname())
                .reviewTitle(dto.getReviewTitle())
                .reviewContext(dto.getReviewContext())
                .reviewScore(dto.getReviewScore())
                .build();
    }

    public static ReviewAddRequestDto toDto(ReviewAddRequestVo vo) {
        return ReviewAddRequestDto.builder()
                .productUUID(vo.getProductUUID())
                .memberUUID(vo.getMemberUUID())
                .memberMaskingId(vo.getMemberMaskingId())
                .memberNickname(vo.getMemberNickname())
                .reviewTitle(vo.getReviewTitle())
                .reviewContext(vo.getReviewContext())
                .reviewScore(vo.getReviewScore())
                .build();
    }

}