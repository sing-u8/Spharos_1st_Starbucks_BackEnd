package TRaMis8khae.starbucks.member.dto;

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
}
