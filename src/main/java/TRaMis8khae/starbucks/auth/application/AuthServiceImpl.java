package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.SignUpRequestDto;
import TRaMis8khae.starbucks.auth.infrastructure.AuthRepository;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        Member member = authRepository.findByEmail(signUpRequestDto.getEmail()).orElse(null);
        if (member != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
        authRepository.save(signUpRequestDto.toEntity(passwordEncoder));
    }

    private String createToken(Authentication authentication) {
        return jwtTokenProvider.generateAccessToken(authentication);
    }
}
