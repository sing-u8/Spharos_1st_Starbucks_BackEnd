package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryAddressResponseDto {

    private boolean addressDefaultCheck;
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;

    public MemberAddressResponseVo toResponseVo() {
        return MemberAddressResponseVo.builder()
                .addressDefaultCheck(addressDefaultCheck)
                .addressDetail(addressDetail)
                .deliveryMemo(deliveryMemo)
                .deliveryAddressNickname(deliveryAddressNickname)
                .recipient(recipient)
                .phone1(phone1)
                .phone2(phone2)
                .build();
    }

}
