package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseDeleteRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.vo.PurchaseAddRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseDeleteRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PurchaseService {

    void addPurchase(PurchaseAddRequestDto dto);

    PurchaseReadResponseDto findPurchase(PurchaseReadRequestDto dto);

    Page<PurchaseReadResponseDto> findPurchases(Pageable pageable);

    void deletePurchase(PurchaseDeleteRequestDto vo);
}