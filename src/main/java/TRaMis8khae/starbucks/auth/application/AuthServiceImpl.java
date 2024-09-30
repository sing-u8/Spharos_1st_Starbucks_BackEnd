package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.in.*;
import TRaMis8khae.starbucks.auth.dto.out.FindMemberResponseDto;
import TRaMis8khae.starbucks.auth.dto.out.LogInResponseDto;
import TRaMis8khae.starbucks.auth.dto.out.TermsResponseDto;
import TRaMis8khae.starbucks.auth.entity.*;
import TRaMis8khae.starbucks.auth.infrastructure.AuthRepository;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.application.MemberServiceImpl;
import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.infrastructure.MarketingConsentListRepository;
import TRaMis8khae.starbucks.member.infrastructure.MarketingRepository;
import TRaMis8khae.starbucks.member.infrastructure.TermConsentListRepository;
import TRaMis8khae.starbucks.member.infrastructure.TermRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final MemberServiceImpl memberServiceImpl;

    private final TermConsentListRepository termConsentListRepository;
    private final MarketingRepository marketingRepository;
    private final MarketingConsentListRepository marketingConsentListRepository;
    private final TermRepository termRepository;

    @Override
    @Transactional
    public void  signUp(SignUpRequestDto signUpRequestDto) {

        // 이미 존재하는 회원인지 확인
        if (authRepository.findByLoginId(signUpRequestDto.getLoginId()).isPresent()) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_USER);
        }

        String loginId = signUpRequestDto.getLoginId();

        // loginId 첫글자 부터 3글자를 제외한 나머지를 *로 마스킹
        String memberMaskingId = loginId.substring(0, 3) + "*".repeat(loginId.length() - 3);

        log.info("^^^^^^memberMaskingId: " + memberMaskingId);

        Member newMember = signUpRequestDto.toEntity(passwordEncoder, memberMaskingId);

        authRepository.save(newMember);

        termConsentListRepository.save(TermsConsentList.builder()
                .memberUUID(newMember.getMemberUUID())
                .termsConsentChecked(true)
                .build());

        marketingConsentListRepository.save(MarketingConsentList.builder()
                        .emailConsentChecked(signUpRequestDto.getEmailMarketingConsent())
                        .smsConsentChecked(signUpRequestDto.getSMSMarketingConsent())
                        .build()
        );

    }

    @Override
    @Transactional
    public void signOut(String memberUUID) {

        authRepository.deleteByMemberUUID(memberUUID);

    }


    @Override
    public LogInResponseDto logIn(LogInRequestDto logInRequestDto) {

        Member member = authRepository.findByLoginId(logInRequestDto.getLoginId()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_LOGIN)
        );

        try {
            String accessToken = generateAccessToken(member.getMemberUUID());
            String refreshToken = generateRefreshToken(authenticate(member, logInRequestDto.getPassword()));
            LogInResponseDto logInResponseDto = LogInResponseDto.toDto(member, accessToken, refreshToken);
            return logInResponseDto;
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_LOGIN);
        }

    }

    @Override
    @Transactional
    public void updateMemberInfo(String memberUUID, UpdateMemberInfoRequestDto requestDto) {

        Member member = authRepository.findByMemberUUID(memberUUID).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NO_EXIST_USER)
        );

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

    @Override
    public List<TermsResponseDto> getTermsConsentList() {
        List<Terms> terms = termRepository.findAll();
        return terms.stream()
                .map(TermsResponseDto::toDto)
                .toList();
    }


    private Authentication authenticate(Member member, String inputPassword) {
        AuthUserDetail authUserDetail = new AuthUserDetail(member);
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authUserDetail.getUsername(),
                        inputPassword
                )
        );
    }

}