package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

}
