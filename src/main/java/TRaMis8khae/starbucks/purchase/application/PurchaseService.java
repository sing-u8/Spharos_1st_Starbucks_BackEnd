package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.vo.PurchaseRequestVo;

import java.util.Optional;

public interface PurchaseService {

    void addPurchase(PurchaseRequestVo purchaseRequestVo);

//    Optional<Purchase> findBySerialNum(String serialNum);

}