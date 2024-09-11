package TRaMis8khae.starbucks.purchase.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.purchase.application.PurchaseService;
import TRaMis8khae.starbucks.purchase.dto.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseDeleteRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.vo.PurchaseAddRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseDeleteRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase") // 임시
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/add")
    public CommonResponseEntity<Void> addPurchase(@RequestBody PurchaseAddRequestVo vo) {

        log.info("PurchaseAddRequestVo: {}", vo);
        String serialNum = UUID.randomUUID().toString();
        LocalDateTime purchaseDate = LocalDateTime.now();

        PurchaseAddRequestDto requestDto = PurchaseAddRequestDto.toDto(vo, serialNum, purchaseDate);
        log.info("PurchaseAddRequestDto: {}", requestDto);

        purchaseService.addPurchase(requestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    // 주문 단 건 조회
    @GetMapping("/find/{serialNum}")
    public CommonResponseEntity<PurchaseReadResponseVo> findPurchase(@PathVariable String serialNum) {

        PurchaseReadRequestVo requestVo = PurchaseReadRequestVo.builder()
                .serialNum(serialNum)
                .build();

        PurchaseReadRequestDto requestDto = PurchaseReadRequestDto.toDto(requestVo);

        PurchaseReadResponseDto responseDto = purchaseService.findPurchase(requestDto);

        PurchaseReadResponseVo responseVo = responseDto.toVo();

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                responseVo);
    }

    // 주문 전체 조회 - 페이징
    @GetMapping("/find")
    public CommonResponseEntity<Page<PurchaseReadResponseVo>> findPurchase(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PurchaseReadResponseDto> responseDtos = purchaseService.findPurchases(pageable);

        Page<PurchaseReadResponseVo> responseVos = responseDtos.map(PurchaseReadResponseDto::toVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                responseVos);
    }

    // 주문 삭제
    @DeleteMapping("/delete/{serialNum}")
    public CommonResponseEntity<Void> deletePurchase(@PathVariable String serialNum) {

        PurchaseDeleteRequestVo requestVo = PurchaseDeleteRequestVo.builder()
                .serialNum(serialNum)
                .build();

        PurchaseDeleteRequestDto requestDto = PurchaseDeleteRequestDto.toDto(requestVo);
        log.info("PurchaseDeleteRequestDto: {}", requestDto);

        purchaseService.deletePurchase(requestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }
}