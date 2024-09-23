package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.entity.PurchaseProductList;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseProductListRepository;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductListRepository purchaseProductListRepository;

    @Transactional
    @Override
    public void addPurchase(PurchaseAddRequestDto requestDto) {

        Purchase purchase = requestDto.toPurchase();
        log.info("purchase: {}", purchase);

        PurchaseProductList purchaseProductList = requestDto.toPurchaseProductList();
        log.info("purchaseProductList: {}", purchaseProductList);

        purchaseRepository.save(purchase);
        purchaseProductListRepository.save(purchaseProductList);
    }

    @Override
    public PurchaseReadResponseDto findPurchase(PurchaseReadRequestDto requestDto) {

        Purchase purchase = purchaseRepository.findBySerialNumber(requestDto.getSerialNum()).orElseThrow();
        log.info("purchase: {}", purchase);

        return PurchaseReadResponseDto.toDto(purchase);
    }

    @Override
    public Page<PurchaseReadResponseDto> findPurchases(Pageable pageable) {
        return purchaseRepository.findPurchases(pageable);
    }

    // todo : 주문 삭제보다는 주문 취소, 환불 쪽으로 봐야 한다
    @Transactional
    @Override
    public void deletePurchase(String serialNum) {

        Purchase purchase = purchaseRepository.findBySerialNumber(serialNum).orElseThrow();
        log.info("purchase: {}", purchase);

        purchaseRepository.delete(purchase);
    }

}