package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.in.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.in.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.out.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.entity.PurchaseProductList;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseProductListRepository;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    public PurchaseReadResponseDto findPurchase(PurchaseReadRequestDto requestDto, String memberUUID) {

        Purchase purchase = purchaseRepository.findBySerialNumberAndMemberUUID(requestDto.getSerialNum(), memberUUID).orElseThrow();
        log.info("purchase: {}", purchase);

        return PurchaseReadResponseDto.toDto(purchase);
    }

    @Override
    public Slice<PurchaseReadResponseDto> findPurchases(Pageable pageable, String memberUUID) {
        return purchaseRepository.findPurchases(pageable, memberUUID);
    }

    @Transactional
    @Override
    public void deletePurchase(String serialNum, String memberUUID) {

        Purchase purchase = purchaseRepository.findBySerialNumberAndMemberUUID(serialNum, memberUUID).orElseThrow();
        log.info("purchase: {}", purchase);

        purchaseRepository.delete(purchase);
    }

}