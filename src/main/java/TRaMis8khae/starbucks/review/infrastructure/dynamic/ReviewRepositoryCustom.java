package TRaMis8khae.starbucks.review.infrastructure.dynamic;

import TRaMis8khae.starbucks.review.dto.ReviewReadResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {
    Page<ReviewReadResponseDto> findReviews(Pageable pageable);
}