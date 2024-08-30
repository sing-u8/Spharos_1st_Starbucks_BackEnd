package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.SignInRequestDto;
import TRaMis8khae.starbucks.auth.dto.SignInResponseDto;
import TRaMis8khae.starbucks.auth.dto.SignUpRequestDto;
import TRaMis8khae.starbucks.auth.infrastructure.AuthRepository;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {
        Member member = authRepository.findByLoginId(signUpRequestDto.getLoginId()).orElse(null);
        if (member != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
        authRepository.save(signUpRequestDto.toEntity(passwordEncoder));
    }

    @Override
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto) {

        log.info("signInRequestDto : {}", signInRequestDto);

        // 로그인 아이디로 회원 조회
        Member member = authRepository.findByLoginId(signInRequestDto.getLoginId()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디를 가진 회원이 없습니다.")
        );
        log.info("member : {}", member);

        // 비밀번호 검증
        if (!passwordEncoder.matches(signInRequestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            member.getLoginId(),
                            signInRequestDto.getPassword()
                    )
            );

            // 성공 시 토큰 생성
            return SignInResponseDto.builder()
                    .accessToken(createToken(authentication))
                    .name(member.getName())
                    .uuid(member.getMemberUuid()).build();
        } catch (Exception e) {
            log.error("Authentication failed!!! Check log!!!", e);
            throw new IllegalArgumentException("로그인 실패");
        }
    }


    private String createToken(Authentication authentication) {
        return jwtTokenProvider.generateAccessToken(authentication);
    }
}
