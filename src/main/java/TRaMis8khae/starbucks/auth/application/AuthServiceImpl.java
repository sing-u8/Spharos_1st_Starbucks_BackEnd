package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.*;
import TRaMis8khae.starbucks.auth.infrastructure.AuthRepository;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.entity.Member;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
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

        Member newMember = signInRequestDto.toEntity(passwordEncoder);

        authRepository.save(newMember);

        return SignInResponseDto.builder()
                .nickname(signInRequestDto.getNickname())
                .build();

    }

    @Override
    @Transactional
    public void signOut(String memberUUID, String accessToken) {

        Member member = authRepository.findByMemberUUID(memberUUID).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")
        );

        Claims claims = jwtTokenProvider.getClaims(accessToken);

        String memberUuidFromToken = claims.get("memberUUID", String.class);

        if (!memberUUID.equals(memberUuidFromToken)) {
            throw new IllegalArgumentException("토큰과 회원 정보가 일치하지 않습니다.");
        }

        authRepository.deleteByMemberUUID(memberUUID);

    }

    @Override
    public LogInResponseDto logIn(LogInRequestDto logInRequestDto) {

        Member member = authRepository.findByLoginId(logInRequestDto.getLoginId()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디를 가진 회원이 없습니다.")
        );

        if (!passwordEncoder.matches(logInRequestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        try {
            log.info("try 실행");

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            member.getMemberUUID(),
                            logInRequestDto.getPassword()
                    )

            );
            return LogInResponseDto.builder()
                    .accessToken(generateAccessToken(member.getMemberUUID()))
                    .refreshToken(generateRefreshToken(authentication))
                    .nickname(member.getNickname())
                    .memberUUID(member.getMemberUUID())
                    .build();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Override
    @Transactional
    public void updateMemberInfo(String memberUUID, String accessToken, ModifyMemberInfoRequestDto modifyMemberInfoRequestDto) {
        Member member = authRepository.findByMemberUUID(memberUUID).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")
        );

        Claims claims = jwtTokenProvider.getClaims(accessToken);

        String memberUuidFromToken = claims.get("memberUUID", String.class);

        if (!memberUUID.equals(memberUuidFromToken)) {
            throw new IllegalArgumentException("토큰과 회원 정보가 일치하지 않습니다.");
        }

        member.updateNickname(modifyMemberInfoRequestDto.getNickname());
        member.updatePhoneNumber(modifyMemberInfoRequestDto.getPhoneNumber());

    }

    @Override
    public FindMemberResponseDto findMember(FindMemberRequestDto findMemberRequestDto) {
        Member member = authRepository.findByNameAndPhoneNumber(
                findMemberRequestDto.getName(),
                findMemberRequestDto.getPhoneNumber()).orElseThrow(
                () -> new IllegalArgumentException("해당 이름과 전화번호를 가진 회원이 없습니다.")
        );

        return FindMemberResponseDto.builder()
                .loginId(member.getNickname())
                .build();
    }

    public String generateAccessToken(String memberUUID) {
        return jwtTokenProvider.generateAccessToken(memberUUID);
    }

    public String generateRefreshToken(Authentication authentication) {
        return jwtTokenProvider.generateRefreshToken(authentication);
    }

}