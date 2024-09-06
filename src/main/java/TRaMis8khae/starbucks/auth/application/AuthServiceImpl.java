package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.LogInRequestDto;
import TRaMis8khae.starbucks.auth.dto.LogInResponseDto;
import TRaMis8khae.starbucks.auth.dto.SignInRequestDto;
import TRaMis8khae.starbucks.auth.dto.SignInResponseDto;
import TRaMis8khae.starbucks.auth.infrastructure.AuthRepository;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.entity.Member;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto) {
        Member member = authRepository.findByLoginId(signInRequestDto.getLoginId()).orElse(null);
        if (member != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }

//        String Uuid = UUID.randomUUID().toString();
        Member newMember = signInRequestDto.toEntity(passwordEncoder);
//        newMember.setMemberUUID(Uuid);

//        log.info("newMember: {}", newMember);

//        authRepository.save(signInRequestDto.toEntity(passwordEncoder));
        authRepository.save(newMember);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequestDto.getLoginId(),
                        signInRequestDto.getPassword()
                )
        );

//        String accessToken = generateAccessToken(Uuid);
//        String refreshToken = generateRefreshToken(authentication);

//        log.info("accessToken : {}", accessToken);
//        log.info("refreshToken : {}", refreshToken);

        return SignInResponseDto.builder()
//                .accessToken(accessToken)
//                .refreshToken(refreshToken)
                .nickname(signInRequestDto.getNickname())
//                .uuid(Uuid)
                .build();
    }

    @Override
    public void signOut(String memberUUID, String accessToken) {
        log.info("들어옴!!!!!!!!!!");
        Member member = authRepository.findByMemberUUID(memberUUID).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")
        );

        Claims claims = jwtTokenProvider.getClaims(accessToken);
        if (!memberUUID.equals(claims.getSubject())) {
            throw new IllegalArgumentException("토큰과 회원 정보가 일치하지 않습니다.");
        }

        authRepository.deleteByMemberUUID(memberUUID);
    }


    @Override
    public LogInResponseDto logIn(LogInRequestDto logInRequestDto) {

        log.info("logInRequestDto : {}", logInRequestDto);

        // 로그인 아이디로 회원 조회
        Member member = authRepository.findByLoginId(logInRequestDto.getLoginId()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디를 가진 회원이 없습니다.")
        );

        // 비밀번호 검증
        if (!passwordEncoder.matches(logInRequestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        log.info("member : {}", member);

        // 인증 객체 생성 및 반환
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        member.getLoginId(),
                        logInRequestDto.getPassword()
                )
        );

        String accessToken = generateAccessToken(member.getMemberUUID());
        String refreshToken = generateRefreshToken(authentication);

        log.info("accessToken : {}", accessToken);
        log.info("refreshToken : {}", refreshToken);

        return LogInResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .nickname(member.getNickname())
                .uuid(member.getMemberUUID())
                .build();
    }


    public String generateAccessToken(String memberUUID) {
        return jwtTokenProvider.generateAccessToken(memberUUID);
    }

    public String generateRefreshToken(Authentication authentication) {
        return jwtTokenProvider.generateRefreshToken(authentication);
    }
}
