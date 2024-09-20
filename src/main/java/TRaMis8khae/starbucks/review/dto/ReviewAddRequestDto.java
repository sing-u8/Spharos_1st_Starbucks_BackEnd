package TRaMis8khae.starbucks.review.dto;

import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.vo.ReviewAddRequestVo;
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

    private String productUUID;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private List<Media> mediaList;

    private LocalDateTime registDate;

    public static ReviewAddRequestDto toDto(ReviewAddRequestVo vo) {
        return ReviewAddRequestDto.builder()
                .productUUID(vo.getProductUUID())
                .memberUUID(vo.getMemberUUID())
                .memberMaskingId(vo.getMemberMaskingId())
                .reviewContext(vo.getReviewContext())
                .reviewScore(vo.getReviewScore())
                .mediaList(vo.getMediaList())
                .registDate(vo.getRegistDate())
                .build();
    }

    public Review toEntity() {
        return Review.builder()
                .productUUID(this.productUUID)
                .memberUUID(this.memberUUID)
                .memberMaskingId(this.memberMaskingId)
                .reviewContext(this.reviewContext)
                .reviewScore(this.reviewScore)
                .mediaList(this.mediaList)
                .registDate(this.registDate)

                .build();
    }

}