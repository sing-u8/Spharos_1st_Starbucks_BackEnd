package TRaMis8khae.starbucks.review.infrastructure.dynamic;

import TRaMis8khae.starbucks.review.dto.out.ReviewReadResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewReadResponseDto> findReviews(Pageable pageable, String productUUID);
}