package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.PurchaseRequestDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
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

    @Override
    public void addPurchase(PurchaseRequestVo purchaseRequestVo) {
        // todo 주문배송 리포지토리에서 꺼내야 함
        String serialNum = UUID.randomUUID().toString();
        LocalDateTime purchaseDate = LocalDateTime.now();

        log.info("purchaseRequestVo: {}", purchaseRequestVo);

        PurchaseRequestDto purchaseRequestDto = PurchaseRequestDto.toDto(
                purchaseRequestVo,
                serialNum,
                purchaseDate);

        log.info("purchaseRequestDto: {}", purchaseRequestDto);

        Purchase purchase = purchaseRequestDto.toEntity();

        log.info("purchase: {}", purchase);

        purchaseRepository.save(purchase);

        // todo 상품주문리스트 추가 필요

    }

}