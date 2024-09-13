package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.vo.DeliveryAddressRequestVo;
import lombok.Builder;
import lombok.Getter;
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

    public static DeliveryAddressRequestDto toDto(DeliveryAddressRequestVo deliveryAddressRequestVo) {
        return DeliveryAddressRequestDto.builder()
                .addressDetail(deliveryAddressRequestVo.getAddressDetail())
                .deliveryMemo(deliveryAddressRequestVo.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressRequestVo.getDeliveryAddressNickname())
                .recipient(deliveryAddressRequestVo.getRecipient())
                .phone1(deliveryAddressRequestVo.getPhone1())
                .phone2(deliveryAddressRequestVo.getPhone2())
                .build();
    }

    public DeliveryAddress toEntity() {
        return DeliveryAddress.builder()
                .addressDetail(this.getAddressDetail())
                .deliveryMemo(this.getDeliveryMemo())
                .deliveryAddressNickname(this.getDeliveryAddressNickname())
                .recipient(this.getRecipient())
                .phone1(this.getPhone1())
                .phone2(this.getPhone2())
                .build();
    }

}
