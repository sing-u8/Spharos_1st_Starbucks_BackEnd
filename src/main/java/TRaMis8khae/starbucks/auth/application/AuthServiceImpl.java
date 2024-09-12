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

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void  signUp(SignUpRequestDto signUpRequestDto) {

        Member member = authRepository.findByLoginId(signUpRequestDto.getLoginId()).orElse(null);
        if (member != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }

        Member newMember = signUpRequestDto.toEntity(passwordEncoder);

        authRepository.save(newMember);

    }

    @Override
    @Transactional
    public void signOut(String memberUUID, String accessToken) {

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
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            member.getMemberUUID(),
                            logInRequestDto.getPassword()
                    )
            );
            LogInResponseDto logInResponseDto = LogInResponseDto.toDto(
                    member,
                    generateAccessToken(member.getMemberUUID()),
                    generateRefreshToken(authentication));

            return logInResponseDto;

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Override
    @Transactional
    public void updateMemberInfo(String memberUUID, String accessToken, ModifyMemberInfoRequestDto requestDto) {
        Member member = authRepository.findByMemberUUID(memberUUID).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")
        );

        Claims claims = jwtTokenProvider.getClaims(accessToken);

        String memberUuidFromToken = claims.get("memberUUID", String.class);

        if (!memberUUID.equals(memberUuidFromToken)) {
            throw new IllegalArgumentException("토큰과 회원 정보가 일치하지 않습니다.");
        }

        Member updatedMember = requestDto.toEntity(member);

        authRepository.save(updatedMember);
    }

    @Override
    public FindMemberResponseDto findMember(FindMemberRequestDto findMemberRequestDto) {

        Member member = authRepository.findByNameAndPhoneNumber(
                findMemberRequestDto.getName(),
                findMemberRequestDto.getPhoneNumber()).orElseThrow(
                () -> new IllegalArgumentException("해당 이름과 전화번호를 가진 회원이 없습니다.")
        );

        FindMemberResponseDto findMemberResponseDto = FindMemberResponseDto.toDto(member);

        return findMemberResponseDto;

    }

    @Override
    public void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto) {

    }

    public String generateAccessToken(String memberUUID) {
        return jwtTokenProvider.generateAccessToken(memberUUID);
    }

    public String generateRefreshToken(Authentication authentication) {
        return jwtTokenProvider.generateRefreshToken(authentication);
    }

}