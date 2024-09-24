package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.review.dto.in.ReviewAddRequestDto;
import TRaMis8khae.starbucks.review.dto.out.ReviewReadResponseDto;
import TRaMis8khae.starbucks.review.dto.in.ReviewUpdateRequestDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ReviewService {

    void addReview(ReviewAddRequestDto dto);

    Slice<ReviewReadResponseDto> findReviews(Pageable pageable, String productUUID);

    void updateReview(ReviewUpdateRequestDto dto);

    void deleteReview(Long id, String memberUUID);
}