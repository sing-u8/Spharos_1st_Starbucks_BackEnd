package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.entity.AuthUserDetail;
import TRaMis8khae.starbucks.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberUUID) throws UsernameNotFoundException {
        return new AuthUserDetail(memberRepository.findByMemberUUID(memberUUID).orElseThrow(() -> new UsernameNotFoundException(memberUUID)));
    }
}
