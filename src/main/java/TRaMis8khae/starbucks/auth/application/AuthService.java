package TRaMis8khae.starbucks.auth.application;

import TRaMis8khae.starbucks.auth.dto.SignUpRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    void signUp(SignUpRequestDto signUpRequestDto);
}


