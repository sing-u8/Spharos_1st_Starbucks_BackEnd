package TRaMis8khae.starbucks.member.dto.in;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.vo.in.DeliveryAddressRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DeliveryAddressAddRequestDto {
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;
    private boolean addressDefaultCheck;
    private String memberUUID;

    @Builder
    public DeliveryAddressAddRequestDto(String addressDetail,
                                        String deliveryMemo,
                                        String deliveryAddressNickname,
                                        String recipient,
                                        String phone1,
                                        String phone2,
                                        boolean addressDefaultCheck,
                                        String memberUUID) {
        this.addressDetail = addressDetail;
        this.deliveryMemo = deliveryMemo;
        this.deliveryAddressNickname = deliveryAddressNickname;
        this.recipient = recipient;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.addressDefaultCheck = addressDefaultCheck;
        this.memberUUID = memberUUID;
    }

    public static DeliveryAddressAddRequestDto toDto(DeliveryAddressRequestVo deliveryAddressRequestVo,
                                                     String memberUUID) {
        return DeliveryAddressAddRequestDto.builder()
                .addressDefaultCheck(deliveryAddressRequestVo.isAddressDefaultCheck())
                .addressDetail(deliveryAddressRequestVo.getAddressDetail())
                .deliveryMemo(deliveryAddressRequestVo.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressRequestVo.getDeliveryAddressNickname())
                .recipient(deliveryAddressRequestVo.getRecipient())
                .phone1(deliveryAddressRequestVo.getPhone1())
                .phone2(deliveryAddressRequestVo.getPhone2())
                .memberUUID(memberUUID)
                .build();
    }

    public DeliveryAddress toEntity(DeliveryAddressAddRequestDto deliveryAddressAddRequestDto) {
        return DeliveryAddress.builder()
                .addressDetail(deliveryAddressAddRequestDto.getAddressDetail())
                .deliveryMemo(deliveryAddressAddRequestDto.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressAddRequestDto.getDeliveryAddressNickname())
                .recipient(deliveryAddressAddRequestDto.getRecipient())
                .phone1(deliveryAddressAddRequestDto.getPhone1())
                .phone2(deliveryAddressAddRequestDto.getPhone2())
                .build();
    }


}
