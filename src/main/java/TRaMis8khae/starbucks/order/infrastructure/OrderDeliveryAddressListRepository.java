package TRaMis8khae.starbucks.order.infrastructure;

import TRaMis8khae.starbucks.order.entity.OrderDeliveryAddressList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDeliveryAddressListRepository extends JpaRepository<OrderDeliveryAddressList, Long> {
}
