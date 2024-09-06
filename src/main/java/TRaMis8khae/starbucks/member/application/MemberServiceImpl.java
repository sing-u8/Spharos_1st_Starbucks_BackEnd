package TRaMis8khae.starbucks.member.application;


import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.domain.Member;
import TRaMis8khae.starbucks.member.dto.MemberSignUpDto;
import TRaMis8khae.starbucks.member.infrastructure.MemberRepository;
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
}
