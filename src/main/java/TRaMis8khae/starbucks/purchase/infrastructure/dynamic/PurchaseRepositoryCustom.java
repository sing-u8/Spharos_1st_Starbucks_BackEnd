package TRaMis8khae.starbucks.purchase.infrastructure.dynamic;

import TRaMis8khae.starbucks.purchase.dto.out.PurchaseReadResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface PurchaseRepositoryCustom {
    Slice<PurchaseReadResponseDto> findPurchases(Pageable pageable, String memberUUID);
}