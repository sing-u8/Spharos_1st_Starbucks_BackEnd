package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.dto.UpdateDeliveryAddressRequestDto;

import java.util.List;

public interface MemberAddressService {

    void addDeliveryAddress(String memberUUID, DeliveryAddressRequestDto deliveryAddressRequestDto);
    void deleteDeliveryAddress(Long deliveryAddressId);
    void updateDeliveryAddress(Long deliveryAddressId, String accessToken, UpdateDeliveryAddressRequestDto updateDeliveryAddressRequestDto);


    List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID);
//    DeliveryAddress updateDeliveryAddress(String memberUUID, DeliveryAddressResponseDto deliveryAddressResponseDto);

}