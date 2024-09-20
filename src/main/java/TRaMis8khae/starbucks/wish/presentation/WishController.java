package TRaMis8khae.starbucks.wish.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.wish.application.WishService;
import TRaMis8khae.starbucks.wish.dto.WishAddRequestDto;
import TRaMis8khae.starbucks.wish.dto.WishReadResponseDto;
import TRaMis8khae.starbucks.wish.vo.WishAddRequestVo;
import TRaMis8khae.starbucks.wish.vo.WishAddResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wish")
public class WishController {

    private final WishService wishService;

    // 찜 하기
    @PostMapping("/add")
    public BaseResponse<Void> addWish(@RequestBody WishAddRequestVo requestVo) {

        WishAddRequestDto requestDto = WishAddRequestDto.toDto(requestVo);

        wishService.addWish(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // 찜 목록 조회
    @GetMapping("/find")
    public BaseResponse<Page<WishAddResponseVo>> findWishes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<WishReadResponseDto> responseDtos = wishService.findWishes(pageable);

        List<WishAddResponseVo> responseVoList = responseDtos.stream().map(WishReadResponseDto::toVo).toList();

        Page<WishAddResponseVo> pageResponse = new PageImpl<>(
                responseVoList,
                pageable,
                responseDtos.getTotalElements()  // 총 요소 수
        );

        return new BaseResponse<>(
                pageResponse
        );
    }

    // 찜 해제/삭제
    @PutMapping("/unwish/{productUUID}")
    public BaseResponse<Void> updateWish(@PathVariable String productUUID) {

        wishService.unwish(productUUID);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

}