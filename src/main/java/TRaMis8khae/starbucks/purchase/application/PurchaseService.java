package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PurchaseService {

    void addPurchase(PurchaseAddRequestDto dto);

    PurchaseReadResponseDto findPurchase(PurchaseReadRequestDto dto);

    Page<PurchaseReadResponseDto> findPurchases(Pageable pageable);

    void deletePurchase(String serialNum);
}