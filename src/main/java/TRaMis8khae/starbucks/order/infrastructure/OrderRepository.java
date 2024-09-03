package TRaMis8khae.starbucks.order.infrastructure;

import TRaMis8khae.starbucks.order.entity.Order;
import TRaMis8khae.starbucks.order.infrastructure.dynamic.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
}
