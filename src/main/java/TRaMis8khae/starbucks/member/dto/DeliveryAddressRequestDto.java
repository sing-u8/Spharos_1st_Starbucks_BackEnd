package TRaMis8khae.starbucks.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class DeliveryAddressRequestDto {
    private String addressDetail;
    private String deliveryMemo;
    private String deliveryAddressNickname;
    private String recipient;
    private String phone1;
    private String phone2;
    private boolean addressDefaultCheck;
}
