package TRaMis8khae.starbucks.member.vo.in;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeliveryAddressRequestVo {

    private String addressDetail;

    private String deliveryMemo;

    private String deliveryAddressNickname;

    private String recipient;

    private String phone1;

    private String phone2;

    private boolean addressDefaultCheck;

}
