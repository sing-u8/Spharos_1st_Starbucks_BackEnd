package TRaMis8khae.starbucks.member.dto.out;

import TRaMis8khae.starbucks.member.vo.out.DeliveryAddressResponseVo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryAddressResponseDto {

    private boolean addressDefaultCheck;
    private Long deliveryAddressId;
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;

    public DeliveryAddressResponseVo toVo() {
        return DeliveryAddressResponseVo.builder()
                .addressDefaultCheck(addressDefaultCheck)
                .deliveryAddressId(deliveryAddressId)
                .addressDetail(addressDetail)
                .deliveryMemo(deliveryMemo)
                .deliveryAddressNickname(deliveryAddressNickname)
                .recipient(recipient)
                .phone1(phone1)
                .phone2(phone2)
                .build();
    }

    public static DeliveryAddressResponseDto toDto(DeliveryAddressResponseVo deliveryAddressResponseVo) {
        return DeliveryAddressResponseDto.builder()
                .addressDefaultCheck(deliveryAddressResponseVo.isAddressDefaultCheck())
                .deliveryAddressId(deliveryAddressResponseVo.getDeliveryAddressId())
                .addressDetail(deliveryAddressResponseVo.getAddressDetail())
                .deliveryMemo(deliveryAddressResponseVo.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressResponseVo.getDeliveryAddressNickname())
                .recipient(deliveryAddressResponseVo.getRecipient())
                .phone1(deliveryAddressResponseVo.getPhone1())
                .phone2(deliveryAddressResponseVo.getPhone2())
                .build();
    }

}
