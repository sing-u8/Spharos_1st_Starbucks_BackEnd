package TRaMis8khae.starbucks.wish.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.wish.application.WishService;
import TRaMis8khae.starbucks.wish.dto.WishAddRequestDto;
import TRaMis8khae.starbucks.wish.dto.WishReadResponseDto;
import TRaMis8khae.starbucks.wish.vo.WishAddRequestVo;
import TRaMis8khae.starbucks.wish.vo.WishReadResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wish")
public class WishController {

    private final WishService wishService;

    // 찜 하기
    @PostMapping("/add")
    public CommonResponseEntity<Void> addWish(@RequestBody WishAddRequestVo requestVo) {

        WishAddRequestDto requestDto = WishAddRequestDto.toDto(requestVo);

        wishService.addWish(requestDto);

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "위시리스트 추가 성공",
                null
        );
    }

    // 찜 목록 조회
    @GetMapping("/find")
    public CommonResponseEntity<Page<WishReadResponseVo>> findWishes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<WishReadResponseDto> responseDtos = wishService.findWishes(pageable);

        List<WishReadResponseVo> responseVoList = responseDtos.stream().map(WishReadResponseDto::toVo).toList();

        Page<WishReadResponseVo> pageResponse = new PageImpl<>(
                responseVoList,
                pageable,
                responseDtos.getTotalElements()  // 총 요소 수
        );

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "위시리스트 조회 성공",
                pageResponse
        );
    }

    // 찜 해제/삭제
    @PutMapping("/unwish/{productUUID}")
    public CommonResponseEntity<Void> updateWish(@PathVariable String productUUID) {

        wishService.unwish(productUUID);

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "위시리스트 삭제 성공",
                null
        );
    }

}