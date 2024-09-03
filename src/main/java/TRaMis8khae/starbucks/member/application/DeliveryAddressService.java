package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressDto;
import TRaMis8khae.starbucks.member.dto.MemberAddressListDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;

public interface DeliveryAddressService {
    DeliveryAddress addDeliveryAddress(String memberUUID, DeliveryAddressDto deliveryAddressDto);
}
