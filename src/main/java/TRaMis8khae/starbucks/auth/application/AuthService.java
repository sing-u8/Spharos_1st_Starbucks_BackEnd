package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.in.*;
import TRaMis8khae.starbucks.auth.dto.out.FindMemberResponseDto;
import TRaMis8khae.starbucks.auth.dto.out.LogInResponseDto;
import TRaMis8khae.starbucks.auth.dto.out.TermsResponseDto;
import TRaMis8khae.starbucks.member.entity.Member;

import java.util.List;

public interface AuthService {

    LogInResponseDto logIn(LogInRequestDto logInRequestDto);
    FindMemberResponseDto findMember(FindMemberRequestDto findMemberRequestDto);

    void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto);
    void signUp(SignUpRequestDto SignUpRequestDto);
    void signOut(String memberUUID);
    void updateMemberInfo(String memberUUID, UpdateMemberInfoRequestDto updateMemberInfoRequestDto);

    List<TermsResponseDto> getTermsConsentList();

//    void addTermsConsent(String memberUUID);
//    void addMarketingConsent(Member member, boolean emailConsentChecked, boolean smsConsentChecked);

}