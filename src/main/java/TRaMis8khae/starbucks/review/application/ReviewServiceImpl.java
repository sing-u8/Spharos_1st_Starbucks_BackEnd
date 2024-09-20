package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
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

        if(checkWriteReview(review)) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_REVIEW);
        }

        reviewRepository.save(review);
    }

    @Override
    public Page<ReviewReadResponseDto> findReviews(Pageable pageable) {
        return reviewRepository.findReviews(pageable);
    }

    @Transactional
    @Override
    public ReviewUpdateResponseDto updateReview(Long id, ReviewUpdateRequestDto requestDto) {

        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NO_EXIST_REVIEW)
        );

        Review updateReviewFromDto = requestDto.toEntity(review);

        Review updatedReview = reviewRepository.save(updateReviewFromDto);

        return ReviewUpdateResponseDto.toDto(updatedReview);
    }

    @Transactional
    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    private Boolean checkWriteReview(Review review) {
        return null;
//        return reviewRepository.existsReviewByMemberUUIDAndProductUUID(review);
    }

}