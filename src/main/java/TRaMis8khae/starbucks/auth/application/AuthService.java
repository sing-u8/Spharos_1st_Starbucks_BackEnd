package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.LogInRequestDto;
import TRaMis8khae.starbucks.auth.dto.LogInResponseDto;
import TRaMis8khae.starbucks.auth.dto.SignInRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    void signIn(SignInRequestDto signInRequestDto);
    LogInResponseDto logIn(LogInRequestDto logInRequestDto);
}


