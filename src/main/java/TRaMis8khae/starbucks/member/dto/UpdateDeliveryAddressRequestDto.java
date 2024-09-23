package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.vo.UpdateDeliveryAddressRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UpdateDeliveryAddressRequestDto {
    // test1
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;
    private boolean addressDefaultCheck;

    @Builder
    public UpdateDeliveryAddressRequestDto(String addressDetail, String deliveryMemo, String deliveryAddressNickname, String recipient, String phone1, String phone2, boolean addressDefaultCheck) {
        this.addressDetail = addressDetail;
        this.deliveryMemo = deliveryMemo;
        this.deliveryAddressNickname = deliveryAddressNickname;
        this.recipient = recipient;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.addressDefaultCheck = addressDefaultCheck;
    }

    public static UpdateDeliveryAddressRequestDto toDto(UpdateDeliveryAddressRequestVo requestVo) {
        return UpdateDeliveryAddressRequestDto.builder()
                .addressDetail(requestVo.getAddressDetail())
                .deliveryMemo(requestVo.getDeliveryMemo())
                .deliveryAddressNickname(requestVo.getDeliveryAddressNickname())
                .recipient(requestVo.getRecipient())
                .phone1(requestVo.getPhone1())
                .phone2(requestVo.getPhone2())
                .addressDefaultCheck(requestVo.isAddressDefaultCheck())
                .build();
    }



    public DeliveryAddress toEntity(UpdateDeliveryAddressRequestDto requestDto) {
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
