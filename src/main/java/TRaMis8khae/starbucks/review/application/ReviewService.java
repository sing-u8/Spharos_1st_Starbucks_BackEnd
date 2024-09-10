package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.review.vo.ReviewAddRequestVo;
import TRaMis8khae.starbucks.review.vo.ReviewReadResponseVo;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateRequestVo;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    void addReview(ReviewAddRequestVo vo);

    Page<ReviewReadResponseVo> findReviews(Pageable pageable);

    ReviewUpdateResponseVo updateReview(Long id, ReviewUpdateRequestVo vo);

    void deleteReview(Long id);
}