package TRaMis8khae.starbucks.member.vo;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddMarketingConsentListRequestVo {

    private boolean EmailConsentChecked;

    private boolean SMSConsentChecked;

    private String memberUUID;

}
