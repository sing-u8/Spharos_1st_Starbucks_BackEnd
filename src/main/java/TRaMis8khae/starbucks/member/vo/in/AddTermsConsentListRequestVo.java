package TRaMis8khae.starbucks.member.vo.in;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddTermsConsentListRequestVo {

    private boolean checked;

    private String memberUUID;

}
