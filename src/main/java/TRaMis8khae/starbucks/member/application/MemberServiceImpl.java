package TRaMis8khae.starbucks.member.application;


import TRaMis8khae.starbucks.member.dto.AddMarketingConsentListRequestDto;
import TRaMis8khae.starbucks.member.dto.AddTermsConsentListRequestDto;
import TRaMis8khae.starbucks.member.entity.MarketingConsentList;
import TRaMis8khae.starbucks.member.entity.Terms;
import TRaMis8khae.starbucks.member.entity.TermsConsentList;
import TRaMis8khae.starbucks.member.infrastructure.MemberRepository;
import TRaMis8khae.starbucks.member.infrastructure.TermConsentListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final TermConsentListRepository termConsentListRepository;

    @Override
    public void addTerms(AddTermsConsentListRequestDto requestDto) {

        TermsConsentList termsConsentList = requestDto.toEntity(requestDto);

        termConsentListRepository.save(termsConsentList);
    }

    @Override
    public void addMarketingConsent(AddMarketingConsentListRequestDto requestDto) {

        MarketingConsentList marketingConsentList = requestDto.toEntity(requestDto);
    }
}