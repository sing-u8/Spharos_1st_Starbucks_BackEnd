package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class UpdateDeliveryAddressRequestDto {
    // test
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;
    private boolean addressDefaultCheck;

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
