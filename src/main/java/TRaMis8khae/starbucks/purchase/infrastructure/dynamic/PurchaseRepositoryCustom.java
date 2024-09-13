package TRaMis8khae.starbucks.purchase.infrastructure.dynamic;

import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseRepositoryCustom {
    Page<PurchaseReadResponseDto> findPurchases(Pageable pageable);
}