package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.MarketingConsentList;
import TRaMis8khae.starbucks.member.vo.AddMarketingConsentListRequestVo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddMarketingConsentListRequestDto {

    private boolean EmailConsentChecked;

    private boolean SMSConsentChecked;

    public static AddMarketingConsentListRequestDto toDto(AddMarketingConsentListRequestVo requestVo) {
        return AddMarketingConsentListRequestDto.builder()
                .EmailConsentChecked(requestVo.isEmailConsentChecked())
                .SMSConsentChecked(requestVo.isSMSConsentChecked())
                .build();
    }

    public MarketingConsentList toEntity(AddMarketingConsentListRequestDto requestDto) {
        return MarketingConsentList.builder()
                .emailConsentChecked(requestDto.isEmailConsentChecked())
                .smsConsentChecked(requestDto.isSMSConsentChecked())
                .build();
    }

}
