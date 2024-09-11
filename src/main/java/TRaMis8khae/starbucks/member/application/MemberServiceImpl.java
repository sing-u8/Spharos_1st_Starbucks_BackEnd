package TRaMis8khae.starbucks.member.application;


import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.dto.MemberSignUpDto;
import TRaMis8khae.starbucks.member.entity.Terms;
import TRaMis8khae.starbucks.member.entity.TermsConsentList;
import TRaMis8khae.starbucks.member.infrastructure.MemberRepository;
import TRaMis8khae.starbucks.member.vo.TermsConsentListRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void signUp(MemberSignUpDto memberSignUpDto) {

        log.info("memberSignUpDto : {}", memberSignUpDto);
        Member member = memberSignUpDto.toEntity();
        log.info("member : {}", member);
        memberRepository.save(member);
    }

    @Override
    public void addTerms(TermsConsentListRequestVo termsConsentListRequestVo) {
        Terms terms = Terms.builder()
                .termContent(termsConsentListRequestVo.getTermContent())
                .termName(termsConsentListRequestVo.getTermName())
                .build();

//        memberRepository.save(terms);

        TermsConsentList termsConsentList = TermsConsentList.builder()
                .checked(termsConsentListRequestVo.isChecked())
                .build();

//        memberRepository.save(termsConsentList);
    }



}