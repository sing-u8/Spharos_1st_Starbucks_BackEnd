package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberAddressListRepository extends JpaRepository<MemberAddressList, Long> {

    MemberAddressList findByDeliveryAddress(DeliveryAddress deliveryAddress);
    Optional<MemberAddressList> findByMemberUUIDAndDeliveryAddressId(String memberUUID, Long id);

}
