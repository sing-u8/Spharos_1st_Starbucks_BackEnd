package TRaMis8khae.starbucks.review.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.review.application.ReviewService;
import TRaMis8khae.starbucks.review.vo.ReviewAddRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review") // 임시
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 생성
    @PostMapping("/add")
    CommonResponseEntity<Void> addReview(@RequestBody ReviewAddRequestVo vo) {
        reviewService.addReview(vo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

}