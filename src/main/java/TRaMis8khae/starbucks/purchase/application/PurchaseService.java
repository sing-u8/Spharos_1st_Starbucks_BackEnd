package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.vo.PurchaseCreateRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseDeleteRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PurchaseService {

    void addPurchase(PurchaseCreateRequestVo vo);

    PurchaseReadResponseVo findPurchase(PurchaseReadRequestVo vo);

    Page<PurchaseReadResponseVo> findPurchases(Pageable pageable);

    void deletePurchase(PurchaseDeleteRequestVo vo);
}