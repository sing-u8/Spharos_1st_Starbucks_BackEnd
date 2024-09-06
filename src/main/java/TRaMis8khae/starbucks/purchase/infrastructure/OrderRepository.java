package TRaMis8khae.starbucks.purchase.infrastructure;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.infrastructure.dynamic.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Purchase, Long>, OrderRepositoryCustom {
}
