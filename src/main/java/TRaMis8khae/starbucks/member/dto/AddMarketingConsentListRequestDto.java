package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.Marketing;
import TRaMis8khae.starbucks.member.entity.MarketingConsentList;
import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.vo.AddMarketingConsentListRequestVo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AddMarketingConsentListRequestDto {

    private boolean EmailConsentChecked;
    private boolean SMSConsentChecked;
    private String memberUUID;
    private Long marketingId;

    @Builder
    public AddMarketingConsentListRequestDto(boolean EmailConsentChecked,
                                             boolean SMSConsentChecked,
                                             String memberUUID,
                                             Long marketingId) {
        this.EmailConsentChecked = EmailConsentChecked;
        this.SMSConsentChecked = SMSConsentChecked;
        this.memberUUID = memberUUID;
        this.marketingId = marketingId;
    }

    public static AddMarketingConsentListRequestDto toDto(AddMarketingConsentListRequestVo requestVo) {
        return AddMarketingConsentListRequestDto.builder()
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
