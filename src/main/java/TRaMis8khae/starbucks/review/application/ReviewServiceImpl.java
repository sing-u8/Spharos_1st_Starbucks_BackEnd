package TRaMis8khae.starbucks.review.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.review.dto.in.ReviewAddRequestDto;
import TRaMis8khae.starbucks.review.dto.out.ReviewReadResponseDto;
import TRaMis8khae.starbucks.review.dto.in.ReviewUpdateRequestDto;
import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.entity.ReviewMediaList;
import TRaMis8khae.starbucks.review.infrastructure.ReviewMediaListRepository;
import TRaMis8khae.starbucks.review.infrastructure.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMediaListRepository reviewMediaListRepository;

    @Transactional
    @Override
    public void addReview(ReviewAddRequestDto requestDto) {
        Review review = requestDto.toEntity();
        log.info("review: {}", review);

        reviewRepository.save(review);

        // todo : 상품 평점 업데이트
        // todo : isReviewChecked 업데이트
    }

    @Override
    public Slice<ReviewReadResponseDto> findReviews(Pageable pageable, String productUUID) {

        // 리뷰 데이터를 가져옴
        List<ReviewReadResponseDto> reviewDtos = reviewRepository.findReviews(pageable, productUUID);

        // 각 리뷰에 대해 mediaIdList 설정
        for (ReviewReadResponseDto reviewDto : reviewDtos) {
            Long reviewId = reviewDto.getReviewId();

            List<Long> mediaIds = reviewMediaListRepository.findMediaIdsByReviewId(reviewId);

            reviewDto.setMediaIdList(mediaIds);
        }

        // 다음 페이지가 있는지 여부 계산
        boolean hasNext = reviewDtos.size() == pageable.getPageSize();

        // SliceImpl로 반환
        return new SliceImpl<>(reviewDtos, pageable, hasNext);
    }

    @Transactional
    @Override
    public void updateReview(ReviewUpdateRequestDto requestDto) {
        reviewRepository.save(
                requestDto.toUpdatedEntity(
                        reviewRepository.findByReviewUUID(requestDto.getReviewUUID())
                                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_REVIEW))));
    }

    @Transactional
    @Override
    public void deleteReview(String reviewUUID, String memberUUID) {
        reviewRepository.deleteByReviewUUIDAndMemberUUID(reviewUUID, memberUUID);
    }

}