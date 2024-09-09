package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.vo.PurchaseAddRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseDeleteRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PurchaseService {

    void addPurchase(PurchaseAddRequestVo vo);

    PurchaseReadResponseVo findPurchase(PurchaseReadRequestVo vo);

    Page<PurchaseReadResponseVo> findPurchases(Pageable pageable);

    void deletePurchase(PurchaseDeleteRequestVo vo);
}