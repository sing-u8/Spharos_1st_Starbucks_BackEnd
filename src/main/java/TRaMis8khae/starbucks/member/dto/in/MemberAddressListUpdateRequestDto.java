package TRaMis8khae.starbucks.member.dto.in;

import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberAddressListUpdateRequestDto {

    private boolean addressDefaultCheck;

    @Builder
    public MemberAddressListUpdateRequestDto(Boolean addressDefaultCheck) {
        this.addressDefaultCheck = addressDefaultCheck;
    }

    public MemberAddressList toEntity(MemberAddressList memberAddressList) {
        return MemberAddressList.builder()
                .deliveryAddress(memberAddressList.getDeliveryAddress())
                .memberUUID(memberAddressList.getMemberUUID())
                .addressDefaultCheck(this.addressDefaultCheck)
                .build();
    }

}
