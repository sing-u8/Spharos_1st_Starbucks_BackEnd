package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.review.dto.ReviewAddRequestDto;
import TRaMis8khae.starbucks.review.dto.ReviewReadResponseDto;
import TRaMis8khae.starbucks.review.dto.ReviewUpdateResponseDto;
import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.infrastructure.ReviewRepository;
import TRaMis8khae.starbucks.review.vo.ReviewAddRequestVo;
import TRaMis8khae.starbucks.review.vo.ReviewReadResponseVo;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateRequestVo;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public void addReview(ReviewAddRequestVo requestVo) {

        log.info("ReviewAddRequestVo: {}", requestVo);

        ReviewAddRequestDto requestDto = ReviewAddRequestDto.toDto(requestVo);
        log.info("ReviewAddRequestDto: {}", requestDto);

        Review review = ReviewAddRequestDto.toEntity(requestDto);
        log.info("review: {}", review);

        reviewRepository.save(review);
    }

    @Override
    public Page<ReviewReadResponseVo> findReviews(Pageable pageable) {

        Page<ReviewReadResponseDto> reviews = reviewRepository.findReviews(pageable);

        return reviews.map(ReviewReadResponseDto::toVo);
    }

    @Transactional
    @Override
    public ReviewUpdateResponseVo updateReview(Long id, ReviewUpdateRequestVo vo) {

        Optional<Review> review = reviewRepository.findById(id);

        if (review.isEmpty()) {
            log.error("Review not found. id: {}", id);
        }

        Review findReview = review.get();

        findReview.updateReview(vo.getReviewTitle(), vo.getReviewContext(), vo.getReviewScore());

        Review updatedReview = reviewRepository.save(findReview);

        ReviewUpdateResponseDto responseDto = ReviewUpdateResponseDto.toDto(updatedReview);

        return ReviewUpdateResponseDto.toVo(responseDto);
    }

    @Transactional
    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

}