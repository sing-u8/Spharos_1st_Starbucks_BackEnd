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
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        log.info("!!!!!!!!!signUpRequestVo : {}", signUpRequestVo);
        authService.signUp(new ModelMapper().map(signUpRequestVo, SignInRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }

    @Operation(summary = "LogIn API", description = "LogIn API", tags = {"Auth"})
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
                .nickname(logInRequestVo.getLoginId())
                .build();
        log.info("signInResponseVo : {}", logInResponseVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                logInResponseVo);
    }

//    @Operation(summary = "SignIn API", description = "SignIn API", tags = {"Auth"})
//    @PostMapping("/sign-in")
//    public CommonResponseEntity<SignInResponseVo> signIn(
//            @RequestBody SignInRequestVo signInRequestVo) {
//        ModelMapper modelMapper = new ModelMapper();
//        SignInRequestDto signInRequestDto = SignInRequestDto.builder().
//                loginId(signInRequestVo.getLoginId()).
//                password(signInRequestVo.getPassword()).
//                build();
//        SignInResponseVo signInResponseVo = modelMapper.map(authService.signIn(signInRequestDto), SignInResponseVo.class);
//        log.info("signInResponseVo : {}", signInResponseVo);
//
//        return new CommonResponseEntity<>(
//                HttpStatus.OK,
//                CommonResponseMessage.SUCCESS.getMessage(),
//                signInResponseVo);
//    }
}
