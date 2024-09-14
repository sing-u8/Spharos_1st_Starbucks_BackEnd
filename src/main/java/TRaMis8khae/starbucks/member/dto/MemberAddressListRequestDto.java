package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberAddressListRequestDto {
    private Long memberAddressId;
    private String memberUUID;
    private Long deliveryAddressId;
    private Boolean addressDefaultCheck;

//    public static MemberAddressListRequestDto toDto() {
//        return MemberAddressListRequestDto.builder()
//                .memberAddressId(memberAddressId)
//                .memberUUID(memberUUID)
//                .deliveryAddressId(deliveryAddressId)
//                .addressDefaultCheck(addressDefaultCheck)
//                .build();
//    }

    public static MemberAddressList toEntity(DeliveryAddressRequestDto deliveryAddressRequestDto, DeliveryAddress deliveryAddress, String memberUUID) {
        return MemberAddressList.builder()
                .deliveryAddress(deliveryAddress)
                .memberUUID(memberUUID)
                .addressDefaultCheck(deliveryAddressRequestDto.isAddressDefaultCheck())
                .build();
    }

}
