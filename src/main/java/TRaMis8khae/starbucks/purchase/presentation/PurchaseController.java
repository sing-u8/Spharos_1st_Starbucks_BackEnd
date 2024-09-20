package TRaMis8khae.starbucks.purchase.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.purchase.application.PurchaseService;
import TRaMis8khae.starbucks.purchase.dto.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.vo.PurchaseAddRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/add")
    public BaseResponse<Void> addPurchase(@RequestBody PurchaseAddRequestVo vo) {

        log.info("PurchaseAddRequestVo: {}", vo);
        String serialNum = UUID.randomUUID().toString();
        LocalDateTime purchaseDate = LocalDateTime.now();

        PurchaseAddRequestDto requestDto = PurchaseAddRequestDto.toDto(vo, serialNum, purchaseDate);
        log.info("PurchaseAddRequestDto: {}", requestDto);

        purchaseService.addPurchase(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // 주문 단 건 조회 - 캐싱?
    @GetMapping("/find/{serialNum}")
    public BaseResponse<PurchaseReadResponseVo> findPurchase(@PathVariable String serialNum) {

        PurchaseReadRequestVo requestVo = PurchaseReadRequestVo.builder()
                .serialNum(serialNum)
                .build();

        PurchaseReadRequestDto requestDto = PurchaseReadRequestDto.toDto(requestVo);

        return new BaseResponse<>(
                purchaseService.findPurchase(requestDto).toVo()
        );
    }

    // 주문 전체 조회 - 페이징
    @GetMapping("/find")
    public BaseResponse<Page<PurchaseReadResponseVo>> findPurchases(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return new BaseResponse<>(
                purchaseService.findPurchases(pageable).map(PurchaseReadResponseDto::toVo)
        );
    }

    // 주문 삭제
    @DeleteMapping("/delete/{serialNum}")
    public BaseResponse<Void> deletePurchase(@PathVariable String serialNum) {

        purchaseService.deletePurchase(serialNum);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }
}