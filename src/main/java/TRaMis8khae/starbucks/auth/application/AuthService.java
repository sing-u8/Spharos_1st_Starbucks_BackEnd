package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AuthService {

    SignInResponseDto signIn(SignInRequestDto signInRequestDto);
    LogInResponseDto logIn(LogInRequestDto logInRequestDto);

    void signOut(String memberUUID, String accessToken);
    void updateMemberInfo(String memberUUID, String accessToken, ModifyMemberInfoRequestDto modifyMemberInfoRequestDto);

}