package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.review.dto.ReviewAddRequestDto;
import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.infrastructure.ReviewRepository;
import TRaMis8khae.starbucks.review.vo.ReviewAddRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public void addReview(ReviewAddRequestVo requestVo) {

        log.info("ReviewAddRequestVo: {}", requestVo);

        ReviewAddRequestDto requestDto = ReviewAddRequestDto.toDto(requestVo);
        log.info("ReviewAddRequestDto: {}", requestDto);

        Review review = ReviewAddRequestDto.toEntity(requestDto);
        log.info("review: {}", review);

        reviewRepository.save(review);
    }
}