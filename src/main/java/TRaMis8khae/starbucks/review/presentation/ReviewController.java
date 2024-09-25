package TRaMis8khae.starbucks.review.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import TRaMis8khae.starbucks.review.application.ReviewService;
import TRaMis8khae.starbucks.review.dto.in.ReviewAddRequestDto;
import TRaMis8khae.starbucks.review.dto.out.ReviewReadResponseDto;
import TRaMis8khae.starbucks.review.dto.in.ReviewUpdateRequestDto;
import TRaMis8khae.starbucks.review.vo.in.ReviewAddRequestVo;
import TRaMis8khae.starbucks.review.vo.out.ReviewReadResponseVo;
import TRaMis8khae.starbucks.review.vo.in.ReviewUpdateRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review") // 임시
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 생성
    @Operation(summary = "리뷰 생성", description = "리뷰를 생성합니다", tags = {"Review Service"})
    @PostMapping("/add")
    public BaseResponse<Void> addReview(
            @RequestBody ReviewAddRequestVo requestVo,
            Authentication authentication) {

        if (requestVo.getReviewChecked()) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_REVIEW);
        }

        String memberUUID = authentication.getName();

        String reviewUUID = CodeGenerator.generateCode(36);

        ReviewAddRequestDto requestDto = ReviewAddRequestDto.toDto(requestVo, memberUUID, reviewUUID);

        reviewService.addReview(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // 리뷰 조회
    @Operation(summary = "리뷰 조회", description = "리뷰를 조회합니다", tags = {"Review Service"})
    @GetMapping("/{productUUID}")
    public BaseResponse<Slice<ReviewReadResponseVo>> findReviews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @PathVariable("productUUID") String productUUID) {

        Pageable pageable = PageRequest.of(page, size);

        return new BaseResponse<>(
                reviewService.findReviews(pageable, productUUID).map(ReviewReadResponseDto::toVo)
        );
    }

    // 리뷰 수정
    @Operation(summary = "리뷰 수정", description = "리뷰를 수정합니다", tags = {"Review Service"})
    @PutMapping("/update/{reviewUUID}")
    public BaseResponse<Void> updateReview(
            @PathVariable("reviewUUID") String reviewUUID,
            @RequestBody ReviewUpdateRequestVo requestVo) {

        ReviewUpdateRequestDto requestDto = ReviewUpdateRequestDto.toDto(requestVo, reviewUUID);

        reviewService.updateReview(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // 리뷰 삭제
    @Operation(summary = "리뷰 삭제", description = "리뷰를 삭제합니다", tags = {"Review Service"})
    @DeleteMapping("/delete/{id}")
    public BaseResponse<Void> deleteReview(
            @PathVariable Long id,
            Authentication authentication) {

        String memberUUID = authentication.getName();

        reviewService.deleteReview(id, memberUUID);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

}