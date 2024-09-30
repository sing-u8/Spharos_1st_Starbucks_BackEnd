package TRaMis8khae.starbucks.purchase.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import TRaMis8khae.starbucks.purchase.application.PurchaseService;
import TRaMis8khae.starbucks.purchase.dto.in.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.in.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.out.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.vo.in.PurchaseAddRequestVo;
import TRaMis8khae.starbucks.purchase.vo.in.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.out.PurchaseReadResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Operation(summary = "주문 생성", description = "주문 생성입니다.", tags = {"Purchase Service"})
    @PostMapping("/add")
    public BaseResponse<Void> addPurchase(@RequestBody PurchaseAddRequestVo vo) {

        log.info("PurchaseAddRequestVo: {}", vo);
        String serialNum = CodeGenerator.generateCode(36);
        LocalDateTime purchaseDate = LocalDateTime.now();

        PurchaseAddRequestDto requestDto = PurchaseAddRequestDto.toDto(vo, serialNum, purchaseDate);
        log.info("PurchaseAddRequestDto: {}", requestDto);

        purchaseService.addPurchase(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // 주문 단 건 조회 - 캐싱?
    @Operation(summary = "주문 조회", description = "주문 조회입니다.", tags = {"Purchase Service"})
    @GetMapping("/find/{serialNum}")
    public BaseResponse<PurchaseReadResponseVo> findPurchase(
            @PathVariable String serialNum,
            Authentication authentication) {

        String memberUUID = authentication.getName();

        PurchaseReadRequestVo requestVo = PurchaseReadRequestVo.builder()
                .serialNum(serialNum)
                .build();

        PurchaseReadRequestDto requestDto = PurchaseReadRequestDto.toDto(requestVo);

        return new BaseResponse<>(
                purchaseService.findPurchase(requestDto, memberUUID).toVo()
        );
    }

    // 주문 전체 조회 - 페이징
    @Operation(summary = "주문 전체 조회", description = "주문 전체 조회입니다.", tags = {"Purchase Service"})
    @GetMapping("/find")
    public BaseResponse<Slice<PurchaseReadResponseVo>> findPurchases(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Authentication authentication) {

        Pageable pageable = PageRequest.of(page, size);
        String memberUUID = authentication.getName();

        return new BaseResponse<>(
                purchaseService.findPurchases(pageable, memberUUID).map(PurchaseReadResponseDto::toVo)
        );
    }

    // 주문 삭제
    // todo : 주문 삭제보다는 주문 취소, 환불 쪽으로 봐야하며, 주문 삭제는 관리자가 할 수 있어야 한다
    @Operation(summary = "주문 삭제", description = "주문 삭제입니다.", tags = {"Purchase Service"})
    @DeleteMapping("/delete/{serialNum}")
    public BaseResponse<Void> deletePurchase(
            @PathVariable String serialNum,
            Authentication authentication) {

        String memberUUID = authentication.getName();

        purchaseService.deletePurchase(serialNum, memberUUID);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }
}