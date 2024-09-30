package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.in.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.in.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.out.PurchaseReadResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;


public interface PurchaseService {

    void addPurchase(PurchaseAddRequestDto dto);

    PurchaseReadResponseDto findPurchase(PurchaseReadRequestDto dto, String memberUUID);

    Slice<PurchaseReadResponseDto> findPurchases(Pageable pageable, String memberUUID);

    void deletePurchase(String serialNum, String memberUUID);
}