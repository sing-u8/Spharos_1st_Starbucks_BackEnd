package TRaMis8khae.starbucks.member.vo;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TermsConsentListRequestVo {

    private boolean checked;

    private String termName;

    private String termContent;

}
