package TRaMis8khae.starbucks.wish.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.wish.application.WishService;
import TRaMis8khae.starbucks.wish.dto.in.WishAddRequestDto;
import TRaMis8khae.starbucks.wish.dto.out.WishReadResponseDto;
import TRaMis8khae.starbucks.wish.vo.in.WishAddRequestVo;
import TRaMis8khae.starbucks.wish.vo.out.WishReadResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wish")
public class WishController {

    private final WishService wishService;

    // 찜 하기
    @Operation(summary = "찜 하기", description = "상품을 찜합니다", tags = {"Wish Service"})
    @PostMapping("/add")
    public BaseResponse<Void> wishProduct(
            @RequestBody WishAddRequestVo requestVo,
            Authentication authentication) {

        String memberUUID = authentication.getName();

        WishAddRequestDto requestDto = WishAddRequestDto.toDto(requestVo, memberUUID);

        wishService.addWish(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // 찜 목록 조회
    @Operation(summary = "찜 목록 조회", description = "찜 목록을 조회합니다", tags = {"Wish Service"})
    @GetMapping("/find")
    public BaseResponse<Slice<WishReadResponseVo>> findWishes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Authentication authentication) {

        Pageable pageable = PageRequest.of(page, size);
        String memberUUID = authentication.getName();

        Slice<WishReadResponseDto> responseDtos = wishService.findWishes(pageable, memberUUID);

        Slice<WishReadResponseVo> sliceResponse = new SliceImpl<>(
                responseDtos.stream().map(WishReadResponseDto::toVo).toList(),
                pageable,
                responseDtos.hasNext()
        );

        return new BaseResponse<>(
                sliceResponse
        );
    }

}