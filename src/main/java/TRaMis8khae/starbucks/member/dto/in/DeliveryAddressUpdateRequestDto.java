package TRaMis8khae.starbucks.member.dto.in;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.vo.in.UpdateDeliveryAddressRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DeliveryAddressUpdateRequestDto {
    // test1
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;
    private String memberUUID;
    private boolean addressDefaultCheck;

    @Builder
    public DeliveryAddressUpdateRequestDto(String addressDetail,
                                           String deliveryMemo,
                                           String deliveryAddressNickname,
                                           String recipient,
                                           String phone1,
                                           String phone2,
                                           String memberUUID,
                                           boolean addressDefaultCheck
                                           ) {
        this.addressDetail = addressDetail;
        this.deliveryMemo = deliveryMemo;
        this.deliveryAddressNickname = deliveryAddressNickname;
        this.recipient = recipient;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.addressDefaultCheck = addressDefaultCheck;
        this.memberUUID = memberUUID;
    }

    public static DeliveryAddressUpdateRequestDto toDto(UpdateDeliveryAddressRequestVo requestVo, String memberUUID) {
        return DeliveryAddressUpdateRequestDto.builder()
                .addressDetail(requestVo.getAddressDetail())
                .deliveryMemo(requestVo.getDeliveryMemo())
                .deliveryAddressNickname(requestVo.getDeliveryAddressNickname())
                .recipient(requestVo.getRecipient())
                .phone1(requestVo.getPhone1())
                .phone2(requestVo.getPhone2())
                .addressDefaultCheck(requestVo.isAddressDefaultCheck())
                .memberUUID(memberUUID)
                .build();
    }

    public DeliveryAddress toEntity(DeliveryAddressUpdateRequestDto requestDto) {
        return DeliveryAddress.builder()
                .addressDetail(requestDto.getAddressDetail())
                .deliveryMemo(requestDto.getDeliveryMemo())
                .deliveryAddressNickname(requestDto.getDeliveryAddressNickname())
                .recipient(requestDto.getRecipient())
                .phone1(requestDto.getPhone1())
                .phone2(requestDto.getPhone2())
                .build();
    }

}
