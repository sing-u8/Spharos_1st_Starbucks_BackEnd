package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.*;
import org.springframework.stereotype.Service;

public interface AuthService {

    LogInResponseDto logIn(LogInRequestDto logInRequestDto);
    FindMemberResponseDto findMember(FindMemberRequestDto findMemberRequestDto);

    void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto);
    void signUp(SignUpRequestDto SignUpRequestDto);
    void signOut(String memberUUID);
    void updateMemberInfo(String memberUUID, UpdateMemberInfoRequestDto updateMemberInfoRequestDto);


}