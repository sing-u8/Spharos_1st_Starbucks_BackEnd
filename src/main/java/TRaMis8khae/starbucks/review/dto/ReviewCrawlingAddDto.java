package TRaMis8khae.starbucks.review.dto;

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

    public static ReviewCrawlingAddDto toDto(String rating, String reviewer, String reviewContent) {
        return ReviewCrawlingAddDto.builder()
                .reviewScore(rating)
                .memberMaskingId(reviewer)
                .reviewContext(reviewContent)
                .build();
    }

    public Review toEntity() {
        return Review.builder()
                .reviewScore(Integer.parseInt(reviewScore))
                .memberMaskingId(memberMaskingId)
                .reviewContext(reviewContext)
                .build();
    }

}