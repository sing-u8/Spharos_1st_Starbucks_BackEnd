package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.MemberSignUpDto;
import TRaMis8khae.starbucks.member.vo.TermsConsentListRequestVo;

public interface MemberService {

    void signUp(MemberSignUpDto memberSignUpDto);
    void addTerms(TermsConsentListRequestVo termsConsentListRequestVo);

}