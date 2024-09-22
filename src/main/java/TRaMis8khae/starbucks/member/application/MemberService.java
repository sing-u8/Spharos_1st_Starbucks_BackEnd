package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.AddMarketingConsentListRequestDto;
import TRaMis8khae.starbucks.member.dto.AddTermsConsentListRequestDto;
import TRaMis8khae.starbucks.member.entity.Member;

public interface MemberService {

    void addTerms(Member member,  boolean termsConsentChecked);
    void addMarketingConsent(Member member, boolean emailConsentChecked, boolean smsConsentChecked);

}