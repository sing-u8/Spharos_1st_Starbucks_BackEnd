package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.review.dto.ReviewAddRequestDto;
import TRaMis8khae.starbucks.review.dto.ReviewReadResponseDto;
import TRaMis8khae.starbucks.review.dto.ReviewUpdateRequestDto;
import TRaMis8khae.starbucks.review.dto.ReviewUpdateResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    void addReview(ReviewAddRequestDto dto);

    Page<ReviewReadResponseDto> findReviews(Pageable pageable);

    ReviewUpdateResponseDto updateReview(Long id, ReviewUpdateRequestDto dto);

    void deleteReview(Long id);
}