package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;

import java.util.List;

public interface DeliveryAddressService {
    DeliveryAddress addDeliveryAddress(String memberUUID, DeliveryAddressResponseDto deliveryAddressResponseDto);
    List<MemberAddressResponseVo> getMemberAddress(String memberUUID);
}
