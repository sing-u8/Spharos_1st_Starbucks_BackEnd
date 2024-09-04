package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.vo.MemberAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;

import java.util.List;

public interface DeliveryAddressService {
    void addDeliveryAddress(String memberUUID, MemberAddressRequestVo memberAddressRequestVo);
    List<MemberAddressResponseVo> getMemberDeliveryAddress(String memberUUID);
//    DeliveryAddress updateDeliveryAddress(String memberUUID, DeliveryAddressResponseDto deliveryAddressResponseDto);
//    void deleteDeliveryAddress(String memberUUID, Long deliveryAddressId);
}
