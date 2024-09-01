package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.LogInRequestDto;
import TRaMis8khae.starbucks.auth.dto.SignInRequestDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AuthService {
    void signIn(SignInRequestDto signInRequestDto);
    void deleteMemberByUuid(UUID memberUuid);
//    LogInResponseDto signIn(LogInRequestDto signInRequestDto);
    Authentication logIn(LogInRequestDto logInRequestDto);
}


