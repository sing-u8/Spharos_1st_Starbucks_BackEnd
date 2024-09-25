package TRaMis8khae.starbucks.member.dto.in;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MemberAddressListAddRequestDto {
    private Long memberAddressId;
    private String memberUUID;
    private Long deliveryAddressId;
    private Boolean addressDefaultCheck;

    @Builder
    public MemberAddressListAddRequestDto(Long memberAddressId,
                                          String memberUUID,
                                          Long deliveryAddressId,
                                          Boolean addressDefaultCheck) {
        this.memberAddressId = memberAddressId;
        this.memberUUID = memberUUID;
        this.deliveryAddressId = deliveryAddressId;
        this.addressDefaultCheck = addressDefaultCheck;
    }

    public static MemberAddressListAddRequestDto toDto(DeliveryAddressUpdateRequestDto requestDto) {
        return MemberAddressListAddRequestDto.builder()
                .addressDefaultCheck(requestDto.isAddressDefaultCheck())
                .build();
    }

    public static MemberAddressList toEntity(DeliveryAddressAddRequestDto deliveryAddressAddRequestDto,
                                             DeliveryAddress deliveryAddress) {
        return MemberAddressList.builder()
                .deliveryAddress(deliveryAddress)
                .memberUUID(deliveryAddressAddRequestDto.getMemberUUID())
                .addressDefaultCheck(deliveryAddressAddRequestDto.isAddressDefaultCheck())
                .build();
    }

}
