package TRaMis8khae.starbucks.review.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.review.application.ReviewService;
import TRaMis8khae.starbucks.review.vo.ReviewAddRequestVo;
import TRaMis8khae.starbucks.review.vo.ReviewReadResponseVo;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateRequestVo;
import TRaMis8khae.starbucks.review.vo.ReviewUpdateResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review") // 임시
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 생성
    @PostMapping("/add")
    public CommonResponseEntity<Void> addReview(@RequestBody ReviewAddRequestVo vo) {
        reviewService.addReview(vo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    // 리뷰 조회
    @GetMapping("/find")
    public CommonResponseEntity<Page<ReviewReadResponseVo>> findReviews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ReviewReadResponseVo> responseVo = reviewService.findReviews(pageable);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                responseVo);
    }

    // 리뷰 수정
    @PutMapping("/update/{id}")
    public CommonResponseEntity<ReviewUpdateResponseVo> updateReview(
            @PathVariable Long id,
            @RequestBody ReviewUpdateRequestVo vo) {

        ReviewUpdateResponseVo responseVo = reviewService.updateReview(id, vo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                responseVo);
    }

    // 리뷰 삭제
    @DeleteMapping("/delete/{id}")
    public CommonResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

}