package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
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

    @Transactional
    @Override
    public void addPurchase(PurchaseAddRequestDto requestDto) {

        // todo 주문배송 리포지토리에서 꺼내야 함
        Purchase purchase = requestDto.toEntity();
        log.info("purchase: {}", purchase);

        purchaseRepository.save(purchase);

        // todo 상품주문리스트 추가 필요
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

    @Transactional
    @Override
    public void deletePurchase(String serialNum) {

        Purchase purchase = purchaseRepository.findBySerialNumber(serialNum).orElseThrow();
        log.info("purchase: {}", purchase);

        purchaseRepository.delete(purchase);
    }

}