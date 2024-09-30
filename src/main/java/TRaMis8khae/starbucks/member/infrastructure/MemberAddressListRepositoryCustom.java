package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.vo.out.DeliveryAddressResponseVo;

import java.util.List;

public interface MemberAddressListRepositoryCustom {

    List<DeliveryAddressResponseVo> findMemberAddressWithDeliveryAddress(String memberUUID);

}
