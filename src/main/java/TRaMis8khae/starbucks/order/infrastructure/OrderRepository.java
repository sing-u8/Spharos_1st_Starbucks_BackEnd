package TRaMis8khae.starbucks.order.infrastructure;

import TRaMis8khae.starbucks.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
