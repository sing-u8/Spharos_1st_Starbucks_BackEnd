package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.AddMarketingConsentListRequestDto;
import TRaMis8khae.starbucks.member.dto.AddTermsConsentListRequestDto;
import TRaMis8khae.starbucks.member.entity.*;
import TRaMis8khae.starbucks.member.infrastructure.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final TermConsentListRepository termConsentListRepository;
    private final MarketingRepository marketingRepository;
    private final MarketingConsentListRepository marketingConsentListRepository;
    private final TermRepository termRepository;

    @Override
    public void addTerms(Member member, boolean termsConsentChecked) {

        List<Terms> terms = termRepository.findAll();

        for (Terms term : terms) {
            AddTermsConsentListRequestDto requestDto = AddTermsConsentListRequestDto.builder()
                    .termsConsentChecked(termsConsentChecked)
                    .memberUUID(member.getMemberUUID())
                    .build();

            TermsConsentList termsConsentList = requestDto.toEntity(member, term);

            termConsentListRepository.save(termsConsentList);

        }
    }

    @Override
    public void addMarketingConsent(Member member,
                                    boolean emailConsentChecked,
                                    boolean smsConsentChecked) {

        List<Marketing> marketingList = marketingRepository.findAll();

        for (Marketing marketing : marketingList) {
            AddMarketingConsentListRequestDto requestDto = AddMarketingConsentListRequestDto.builder()
                    .EmailConsentChecked(emailConsentChecked)
                    .SMSConsentChecked(smsConsentChecked)
                    .memberUUID(member.getMemberUUID())
                    .marketingId(marketing.getId())
                    .build();

            MarketingConsentList marketingConsentList = requestDto.toEntity(member, marketing);

            marketingConsentListRepository.save(marketingConsentList);

        }
    }
}