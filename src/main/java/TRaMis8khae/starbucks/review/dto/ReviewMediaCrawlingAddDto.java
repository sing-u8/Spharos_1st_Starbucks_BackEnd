package TRaMis8khae.starbucks.review.dto;

import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.entity.ReviewMediaList;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewMediaCrawlingAddDto {

    private Long mediaId;

    private Review review;

    public static ReviewMediaCrawlingAddDto toDto(Long mediaId, Review review) {
        return ReviewMediaCrawlingAddDto.builder()
                .mediaId(mediaId)
                .review(review)
                .build();
    }

    public ReviewMediaList toEntity() {
        return ReviewMediaList.builder()
                .mediaId(mediaId)
                .review(review)
                .build();
    }

}