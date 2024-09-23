package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.*;
import TRaMis8khae.starbucks.auth.infrastructure.AuthRepository;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.application.MemberServiceImpl;
import TRaMis8khae.starbucks.member.dto.AddMarketingConsentListRequestDto;
import TRaMis8khae.starbucks.member.entity.Marketing;
import TRaMis8khae.starbucks.member.entity.MarketingConsentList;
import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.infrastructure.MarketingConsentListRepository;
import TRaMis8khae.starbucks.member.infrastructure.MarketingRepository;
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
    private final MemberServiceImpl memberServiceImpl;

    @Override
    public void  signUp(SignUpRequestDto signUpRequestDto) {

        // 이미 존재하는 회원인지 확인
        if (authRepository.findByLoginId(signUpRequestDto.getLoginId()).isPresent()) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_USER);
        }

        Member newMember = signUpRequestDto.toEntity(passwordEncoder);

        authRepository.save(newMember);

        log.info(signUpRequestDto.toString());
        log.info(newMember.toString());

        memberServiceImpl.addMarketingConsent(newMember,
                signUpRequestDto.getEmailMarketingConsent(),
                signUpRequestDto.getSMSMarketingConsent()
        );

        // 약관 동의 기능
//        memberServiceImpl.addTerms(newMember,
//                signUpRequestDto.getTermsConsent()
//        );

    }

    @Override
    @Transactional
    public void signOut(String memberUUID, String accessToken) {

        String memberUUIDFromToken = jwtTokenProvider.getMemberUUID(accessToken);

        if (!memberUUID.equals(memberUUIDFromToken)) {
            throw new IllegalArgumentException("토큰과 회원 정보가 일치하지 않습니다.");
        }

        authRepository.deleteByMemberUUID(memberUUID);

    }


    @Override
    public LogInResponseDto logIn(LogInRequestDto logInRequestDto) {

        Member member = authRepository.findByLoginId(logInRequestDto.getLoginId()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_LOGIN)
        );

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            member.getMemberUUID(),
                            logInRequestDto.getPassword()
                    )
            );
            String accessToken = generateAccessToken(member.getMemberUUID());
            String refreshToken = generateRefreshToken(authentication);
            LogInResponseDto logInResponseDto = LogInResponseDto.toDto(member, accessToken, refreshToken);
            return logInResponseDto;
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_LOGIN);
        }

    }

    @Override
    @Transactional
    public void updateMemberInfo(String memberUUID, String accessToken, UpdateMemberInfoRequestDto requestDto) {

        Member member = authRepository.findByMemberUUID(memberUUID).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NO_EXIST_USER)
        );

        String memberUuidFromToken = jwtTokenProvider.getMemberUUID(accessToken);

        if (!memberUUID.equals(memberUuidFromToken)) {
            throw new BaseException(BaseResponseStatus.WRONG_JWT_TOKEN);
        }

        Member updatedMember = requestDto.toEntity(member);

        authRepository.save(updatedMember);
    }

    @Override
    public FindMemberResponseDto findMember(FindMemberRequestDto findMemberRequestDto) {

        Member member = authRepository.findByNameAndPhoneNumber(
                findMemberRequestDto.getName(),
                findMemberRequestDto.getPhoneNumber()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NO_EXIST_USER)
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