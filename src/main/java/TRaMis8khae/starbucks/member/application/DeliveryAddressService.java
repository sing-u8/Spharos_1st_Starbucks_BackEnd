package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.vo.MemberDeliveryAddressRequestVo;

import java.util.List;

public interface DeliveryAddressService {

    void addDeliveryAddress(String memberUUID, DeliveryAddressRequestDto deliveryAddressRequestDto);
    void deleteDeliveryAddress(Long deliveryAddressId);
    void updateDeliveryAddress(String memberUUID, Long id, MemberDeliveryAddressRequestVo memberDeliveryAddressRequestVo);

    List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID);
//    DeliveryAddress updateDeliveryAddress(String memberUUID, DeliveryAddressResponseDto deliveryAddressResponseDto);

}