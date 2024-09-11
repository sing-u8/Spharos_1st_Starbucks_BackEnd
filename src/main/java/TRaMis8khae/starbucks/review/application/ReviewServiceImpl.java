package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.review.dto.ReviewAddRequestDto;
import TRaMis8khae.starbucks.review.dto.ReviewReadResponseDto;
import TRaMis8khae.starbucks.review.dto.ReviewUpdateRequestDto;
import TRaMis8khae.starbucks.review.dto.ReviewUpdateResponseDto;
import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.infrastructure.ReviewRepository;
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
    public void addReview(ReviewAddRequestDto requestDto) {

        Review review = requestDto.toEntity();
        log.info("review: {}", review);

        reviewRepository.save(review);
    }

    @Override
    public Page<ReviewReadResponseDto> findReviews(Pageable pageable) {
        return reviewRepository.findReviews(pageable);
    }

    @Transactional
    @Override
    public ReviewUpdateResponseDto updateReview(Long id, ReviewUpdateRequestDto requestDto) {

        Review review = reviewRepository.findById(id).orElseThrow();

//        review.updateReview(requestDto.getReviewTitle(), requestDto.getReviewContext(), requestDto.getReviewScore());
//
//        Review updatedReview = reviewRepository.save(review);

        // 바뀐 버전, dto에서 Entity update
        Review updateReviewFromDto = requestDto.toEntity(review);

        Review updatedReview = reviewRepository.save(updateReviewFromDto);

        return ReviewUpdateResponseDto.toDto(updatedReview);
    }

    @Transactional
    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

}