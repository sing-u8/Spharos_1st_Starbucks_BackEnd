package TRaMis8khae.starbucks.member.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberAddressResponseVo {

    private Long memberAddressId;

    private String memberUUID;

    private boolean addressDefaultCheck;

    private Long deliveryAddressId;

    private String addressDetail;

    private String deliveryMemo;

    private String deliveryAddressNickname;

    private String recipient;

    private String phone1;

    private String phone2;

}
