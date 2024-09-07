package TRaMis8khae.starbucks.purchase.infrastructure;

import TRaMis8khae.starbucks.purchase.entity.PurchaseProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseProductListRepository extends JpaRepository<PurchaseProductList, Long> {
}
