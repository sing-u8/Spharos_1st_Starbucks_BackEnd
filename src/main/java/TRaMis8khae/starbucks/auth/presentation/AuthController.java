package TRaMis8khae.starbucks.auth.presentation;

import TRaMis8khae.starbucks.auth.application.AuthService;
import TRaMis8khae.starbucks.auth.dto.LogInRequestDto;
import TRaMis8khae.starbucks.auth.dto.SignInRequestDto;
import TRaMis8khae.starbucks.auth.vo.LogInRequestVo;
import TRaMis8khae.starbucks.auth.vo.LogInResponseVo;
import TRaMis8khae.starbucks.auth.vo.SignInRequestVo;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth") // 임시
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @Operation(summary = "SignUp API", description = "SignUp API", tags = {"Auth"})
    @PostMapping("/signin")
    public CommonResponseEntity<Void> signUp(
            @RequestBody SignInRequestVo signUpRequestVo) {
        authService.signIn(new ModelMapper().map(signUpRequestVo, SignInRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, "true", CommonResponseMessage.SUCCESS.getMessage(), null);
    }

    @DeleteMapping("/signout/{memberUuid}")
    public CommonResponseEntity<Void> deleteMemberByUuid(@PathVariable UUID memberUuid) {
        authService.deleteMemberByUuid(memberUuid);
        return new CommonResponseEntity<>(HttpStatus.OK, "true", "회원탈퇴가 완료되었습니다.", null);
    }


    @PostMapping("/login")
    public CommonResponseEntity<LogInResponseVo> LogIn(
            @RequestBody LogInRequestVo logInRequestVo) {
//        ModelMapper modelMapper = new ModelMapper();
        LogInRequestDto logInRequestDto = LogInRequestDto.builder().
                loginId(logInRequestVo.getLoginId()).
                password(logInRequestVo.getPassword()).
                build();

        Authentication authentication = authService.logIn(logInRequestDto);
        String accessToken = jwtTokenProvider.generateAccessToken(authentication);
        String refreshToken = jwtTokenProvider.generateRefreshToken(authentication);

        LogInResponseVo logInResponseVo = LogInResponseVo.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        log.info("signInResponseVo : {}", logInResponseVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "true",
                CommonResponseMessage.SUCCESS.getMessage(),
                logInResponseVo);
    }

}
