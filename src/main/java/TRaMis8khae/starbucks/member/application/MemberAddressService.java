package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.in.DeliveryAddressAddRequestDto;
import TRaMis8khae.starbucks.member.dto.out.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.dto.in.DeliveryAddressUpdateRequestDto;

import java.util.List;

public interface MemberAddressService {

    void addDeliveryAddress(DeliveryAddressAddRequestDto deliveryAddressAddRequestDto);
    void deleteDeliveryAddress(Long deliveryAddressId);
    void updateDeliveryAddress(Long deliveryAddressId,
                               DeliveryAddressUpdateRequestDto deliveryAddressUpdateRequestDto);

    List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID);
//    DeliveryAddress updateDeliveryAddress(String memberUUID, DeliveryAddressResponseDto deliveryAddressResponseDto);

}