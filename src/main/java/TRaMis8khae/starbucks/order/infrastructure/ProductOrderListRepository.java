package TRaMis8khae.starbucks.order.infrastructure;

import TRaMis8khae.starbucks.order.entity.ProductOrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderListRepository extends JpaRepository<ProductOrderList, Long> {
}
