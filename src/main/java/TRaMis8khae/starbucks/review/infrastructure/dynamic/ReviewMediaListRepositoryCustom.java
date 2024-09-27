package TRaMis8khae.starbucks.review.infrastructure.dynamic;

import java.util.List;

public interface ReviewMediaListRepositoryCustom {
    List<Long> findMediaIdsByReviewId(Long reviewId);
}