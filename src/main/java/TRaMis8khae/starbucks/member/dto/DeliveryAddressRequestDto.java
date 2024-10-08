package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.vo.in.DeliveryAddressRequestVo;
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
                .addressDefaultCheck(deliveryAddressRequestVo.isAddressDefaultCheck())
                .addressDetail(deliveryAddressRequestVo.getAddressDetail())
                .deliveryMemo(deliveryAddressRequestVo.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressRequestVo.getDeliveryAddressNickname())
                .recipient(deliveryAddressRequestVo.getRecipient())
                .phone1(deliveryAddressRequestVo.getPhone1())
                .phone2(deliveryAddressRequestVo.getPhone2())
                .build();
    }

    public DeliveryAddress toEntity(DeliveryAddressRequestDto deliveryAddressRequestDto) {
        return DeliveryAddress.builder()
                .addressDetail(deliveryAddressRequestDto.getAddressDetail())
                .deliveryMemo(deliveryAddressRequestDto.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressRequestDto.getDeliveryAddressNickname())
                .recipient(deliveryAddressRequestDto.getRecipient())
                .phone1(deliveryAddressRequestDto.getPhone1())
                .phone2(deliveryAddressRequestDto.getPhone2())
                .build();
    }


}
