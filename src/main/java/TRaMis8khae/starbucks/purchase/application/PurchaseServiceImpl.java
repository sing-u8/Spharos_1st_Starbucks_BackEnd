package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.PurchaseRequestDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.entity.PurchaseDelivery;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseDeliveryRepository;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseRepository;
import TRaMis8khae.starbucks.purchase.vo.PurchaseRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseDeliveryRepository purchaseDeliveryRepository;

    @Override
    public void addPurchase(PurchaseRequestVo purchaseRequestVo) {
        // todo 주문배송 리포지토리에서 꺼내야 함
        PurchaseDelivery purchaseDelivery = new PurchaseDelivery();
        String serialNum = UUID.randomUUID().toString();
        LocalDateTime purchaseDate = LocalDateTime.now();

        PurchaseRequestDto purchaseRequestDto = PurchaseRequestDto.toDto(
                purchaseRequestVo,
                purchaseDelivery,
                serialNum,
                purchaseDate);

        Purchase purchase = purchaseRequestDto.toEntity();

        log.info("purchase: {}", purchase);

        purchaseRepository.save(purchase);

        // todo 주문배송리스트, 상품주문리스트 추가 필요

    }

}