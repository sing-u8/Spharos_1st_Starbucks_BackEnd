package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;

import java.util.List;

public interface MemberAddressService {

    void addDeliveryAddress(String memberUUID, DeliveryAddressRequestDto deliveryAddressRequestDto);
    void deleteDeliveryAddress(Long deliveryAddressId);
    void updateDeliveryAddress(Long deliveryAddressId, DeliveryAddressRequestDto deliveryAddressRequestDto);


    List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID);
//    DeliveryAddress updateDeliveryAddress(String memberUUID, DeliveryAddressResponseDto deliveryAddressResponseDto);

}