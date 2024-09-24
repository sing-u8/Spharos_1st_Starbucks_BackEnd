package TRaMis8khae.starbucks.auth.dto.in;

import TRaMis8khae.starbucks.auth.entity.Marketing;
import TRaMis8khae.starbucks.auth.entity.MarketingConsentList;
import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.vo.in.AddMarketingConsentListRequestVo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MarketingConsentListAddRequestDto {

    private boolean EmailConsentChecked;
    private boolean SMSConsentChecked;
    private String memberUUID;
    private Long marketingId;

    @Builder
    public MarketingConsentListAddRequestDto(boolean EmailConsentChecked, boolean SMSConsentChecked, String memberUUID) {
        this.EmailConsentChecked = EmailConsentChecked;
        this.SMSConsentChecked = SMSConsentChecked;
        this.memberUUID = memberUUID;
    }

    public static MarketingConsentListAddRequestDto toDto(AddMarketingConsentListRequestVo requestVo) {
        return MarketingConsentListAddRequestDto.builder()
                .EmailConsentChecked(requestVo.isEmailConsentChecked())
                .SMSConsentChecked(requestVo.isSMSConsentChecked())
                .memberUUID(requestVo.getMemberUUID())
                .build();
    }

    public MarketingConsentList toEntity(Member member, Marketing marketing) {
        return MarketingConsentList.builder()
                .emailConsentChecked(this.EmailConsentChecked)
                .smsConsentChecked(this.SMSConsentChecked)
                .marketing(marketing)
                .member(member)
                .build();
    }

}
