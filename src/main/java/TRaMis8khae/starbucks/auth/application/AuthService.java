package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    LogInResponseDto logIn(LogInRequestDto logInRequestDto);
    FindMemberResponseDto findMember(FindMemberRequestDto findMemberRequestDto);

    void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto);
    void signUp(SignUpRequestDto SignUpRequestDto);
    void signOut(String memberUUID, String accessToken);
    void updateMemberInfo(String memberUUID, String accessToken, ModifyMemberInfoRequestDto modifyMemberInfoRequestDto);

}