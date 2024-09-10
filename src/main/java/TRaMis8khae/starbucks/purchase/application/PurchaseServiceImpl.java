package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.PurchaseAddRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseDeleteRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadRequestDto;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseRepository;
import TRaMis8khae.starbucks.purchase.vo.PurchaseAddRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseDeleteRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Transactional
    @Override
    public void addPurchase(PurchaseAddRequestVo requestVo) {

        // todo 주문배송 리포지토리에서 꺼내야 함
        String serialNum = UUID.randomUUID().toString();
        LocalDateTime purchaseDate = LocalDateTime.now();

        log.info("PurchaseAddRequestVo: {}", requestVo);

        PurchaseAddRequestDto requestDto = PurchaseAddRequestDto.toDto(
                requestVo,
                serialNum,
                purchaseDate);
        log.info("PurchaseAddRequestDto: {}", requestDto);

        Purchase purchase = PurchaseAddRequestDto.toEntity(requestDto);
        log.info("purchase: {}", purchase);

        purchaseRepository.save(purchase);

        // todo 상품주문리스트 추가 필요

    }

    @Override
    public PurchaseReadResponseVo findPurchase(PurchaseReadRequestVo requestVo) {

        // 요청 처리
        log.info("PurchaseReadRequestVo: {}", requestVo);

        PurchaseReadRequestDto requestDto = PurchaseReadRequestDto.toDto(requestVo);
        log.info("PurchaseReadRequestDto: {}", requestDto);

        Optional<Purchase> purchase = purchaseRepository.findBySerialNumber(requestDto.getSerialNum());
        if (purchase.isEmpty()) {
            log.error("해당 주문이 존재하지 않습니다. serialNum: {}", requestVo);
        }

        // 응답 처리
        Purchase findPurchase = purchase.get();
        log.info("findPurchase: {}", findPurchase);

        PurchaseReadResponseDto responseDto = PurchaseReadResponseDto.toDto(findPurchase);

        return PurchaseReadResponseDto.toVo(responseDto);
    }

    @Override
    public Page<PurchaseReadResponseVo> findPurchases(Pageable pageable) {

        Page<PurchaseReadResponseDto> purchases = purchaseRepository.findPurchases(pageable);

        return purchases.map(PurchaseReadResponseDto::toVo);
    }

    @Transactional
    @Override
    public void deletePurchase(PurchaseDeleteRequestVo vo) {

        // 요청 처리
        log.info("PurchaseDeleteRequestVo: {}", vo);

        PurchaseDeleteRequestDto requestDto = PurchaseDeleteRequestDto.toDto(vo);
        log.info("PurchaseDeleteRequestDto: {}", requestDto);

        Optional<Purchase> purchase = purchaseRepository.findBySerialNumber(requestDto.getSerialNum());
        if (purchase.isEmpty()) {
            log.error("해당 주문이 존재하지 않습니다. serialNum: {}", vo);
        }

        // 응답 처리
        Purchase findPurchase = purchase.get();
        log.info("findPurchase: {}", findPurchase);

        purchaseRepository.delete(findPurchase);
    }

}