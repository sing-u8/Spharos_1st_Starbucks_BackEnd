package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.vo.MemberDeliveryAddressResponseVo;

import java.util.List;

public interface MemberAddressListRepositoryCustom {

    List<MemberDeliveryAddressResponseVo> findMemberAddressWithDeliveryAddress(String memberUUID);

}
