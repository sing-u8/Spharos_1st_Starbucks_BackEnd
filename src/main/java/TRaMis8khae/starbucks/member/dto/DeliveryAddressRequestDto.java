package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.vo.MemberDeliveryAddressRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class DeliveryAddressRequestDto {
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;
    private boolean addressDefaultCheck;

    public static DeliveryAddressRequestDto toDto(MemberDeliveryAddressRequestVo memberDeliveryAddressRequestVo) {
        return DeliveryAddressRequestDto.builder()
                .addressDetail(memberDeliveryAddressRequestVo.getAddressDetail())
                .deliveryMemo(memberDeliveryAddressRequestVo.getDeliveryMemo())
                .deliveryAddressNickname(memberDeliveryAddressRequestVo.getDeliveryAddressNickname())
                .recipient(memberDeliveryAddressRequestVo.getRecipient())
                .phone1(memberDeliveryAddressRequestVo.getPhone1())
                .phone2(memberDeliveryAddressRequestVo.getPhone2())
                .build();
    }

    public DeliveryAddress toEntity() {
        return DeliveryAddress.builder()
                .addressDetail(addressDetail)
                .deliveryMemo(deliveryMemo)
                .deliveryAddressNickname(deliveryAddressNickname)
                .recipient(recipient)
                .phone1(phone1)
                .phone2(phone2)
                .build();
    }

}
