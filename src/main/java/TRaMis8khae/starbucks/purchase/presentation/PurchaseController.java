package TRaMis8khae.starbucks.purchase.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.purchase.application.PurchaseService;
import TRaMis8khae.starbucks.purchase.vo.PurchaseCreateRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseDeleteRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase") // 임시
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/add")
    public CommonResponseEntity<Void> addPurchase(@RequestBody PurchaseCreateRequestVo vo) {
        purchaseService.addPurchase(vo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    // 주문 단 건 조회
    @GetMapping("/find/{serialNum}")
    public CommonResponseEntity<PurchaseReadResponseVo> findPurchase(@PathVariable String serialNum) {
        PurchaseReadRequestVo vo = PurchaseReadRequestVo.builder()
                .serialNum(serialNum)
                .build();

        PurchaseReadResponseVo responseVo = purchaseService.findPurchase(vo);

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
        Page<PurchaseReadResponseVo> responseVo = purchaseService.findPurchases(pageable);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                responseVo);
    }

    // 주문 삭제
    @DeleteMapping("/delete/{serialNum}")
    public CommonResponseEntity<Void> deletePurchase(@PathVariable String serialNum) {
        PurchaseDeleteRequestVo vo = PurchaseDeleteRequestVo.builder()
                .serialNum(serialNum)
                .build();

        purchaseService.deletePurchase(vo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }
}