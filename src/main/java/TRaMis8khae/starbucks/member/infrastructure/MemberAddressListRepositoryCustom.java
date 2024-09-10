package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;

import java.util.List;

public interface MemberAddressListRepositoryCustom {

    List<MemberAddressResponseVo> findMemberAddressWithDeliveryAddress(String memberUUID);

}
