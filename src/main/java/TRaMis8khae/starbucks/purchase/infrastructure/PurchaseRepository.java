package TRaMis8khae.starbucks.purchase.infrastructure;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.infrastructure.dynamic.PurchaseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>, PurchaseRepositoryCustom {
}
