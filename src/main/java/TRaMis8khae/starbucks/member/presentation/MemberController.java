package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.member.application.MemberService;
import TRaMis8khae.starbucks.member.vo.TermsConsentListRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/terms")
    public CommonResponseEntity<Void> terms(@RequestBody TermsConsentListRequestVo termsConsentListRequestVo) {

        memberService.addTerms(termsConsentListRequestVo);
    }
}