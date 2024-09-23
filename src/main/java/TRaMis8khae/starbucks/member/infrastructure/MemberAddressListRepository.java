package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberAddressListRepository extends JpaRepository<MemberAddressList, Long> {

    MemberAddressList findByDeliveryAddress(DeliveryAddress deliveryAddress);
//    MemberAddressList findByMemberUUIDAndId(String memberUUID, Long id);

}
