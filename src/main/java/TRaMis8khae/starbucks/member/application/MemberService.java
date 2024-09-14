package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.AddMarketingConsentListRequestDto;
import TRaMis8khae.starbucks.member.dto.AddTermsConsentListRequestDto;

public interface MemberService {

    void addTerms(AddTermsConsentListRequestDto requestDto);
    void addMarketingConsent(AddMarketingConsentListRequestDto requestDto);

}