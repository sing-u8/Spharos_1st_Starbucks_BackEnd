package TRaMis8khae.starbucks.purchase.infrastructure;

import TRaMis8khae.starbucks.purchase.entity.PurchaseDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDeliveryRepository extends JpaRepository<PurchaseDelivery, Long> {
}
