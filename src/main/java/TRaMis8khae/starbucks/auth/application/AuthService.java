package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.LogInRequestDto;
import TRaMis8khae.starbucks.auth.dto.SignInRequestDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    void signUp(SignInRequestDto signInRequestDto);
//    LogInResponseDto signIn(LogInRequestDto signInRequestDto);
    Authentication logIn(LogInRequestDto logInRequestDto);
}


