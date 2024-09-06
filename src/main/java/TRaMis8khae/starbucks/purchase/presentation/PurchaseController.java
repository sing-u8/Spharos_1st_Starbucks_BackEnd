package TRaMis8khae.starbucks.purchase.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.purchase.application.PurchaseService;
import TRaMis8khae.starbucks.purchase.vo.PurchaseRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase") // 임시
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/add")
    public CommonResponseEntity<PurchaseResponseVo> addPurchase(PurchaseRequestVo purchaseRequestVo) {
        purchaseService.addPurchase(purchaseRequestVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }
}
