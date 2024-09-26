package TRaMis8khae.starbucks.review.dto;

import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.review.entity.Review;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
public class ReviewCrawlingAddDto {

    private String reviewScore;
    private String memberMaskingId;
    private String reviewContext;
    private List<Media> mediaList;
    private String productUUID;

    public static ReviewCrawlingAddDto toDto(String rating, String reviewer, String reviewContent, String productUUID) {
        return ReviewCrawlingAddDto.builder()
                .reviewScore(rating)
                .memberMaskingId(reviewer)
                .reviewContext(reviewContent)
                .productUUID(productUUID)
                .build();
    }

    public Review toEntity() {
        return Review.builder()
                .reviewScore(Integer.parseInt(reviewScore))
                .memberMaskingId(memberMaskingId)
                .reviewContext(reviewContext)
                .productUUID(productUUID)
                .reviewUUID(CodeGenerator.generateCode(36))
                .build();
    }

}