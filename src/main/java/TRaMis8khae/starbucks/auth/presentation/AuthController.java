package TRaMis8khae.starbucks.auth.presentation;

import TRaMis8khae.starbucks.auth.application.AuthService;
import TRaMis8khae.starbucks.auth.dto.LogInRequestDto;
import TRaMis8khae.starbucks.auth.dto.SignInRequestDto;
import TRaMis8khae.starbucks.auth.vo.LogInRequestVo;
import TRaMis8khae.starbucks.auth.vo.LogInResponseVo;
import TRaMis8khae.starbucks.auth.vo.SignInRequestVo;
import TRaMis8khae.starbucks.auth.vo.SignInResponseVo;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @Operation(summary = "SignUp API", description = "SignUp API", tags = {"Auth"})
    @PostMapping("/signin")
    public CommonResponseEntity<SignInResponseVo> signIn(
            @RequestBody SignInRequestVo signInRequestVo) {
        ModelMapper modelMapper = new ModelMapper();
        SignInRequestDto signInRequestDto = modelMapper.map(signInRequestVo, SignInRequestDto.class);
        SignInResponseVo signInResponseVo = modelMapper.map(authService.signIn(signInRequestDto), SignInResponseVo.class);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                signInResponseVo);
    }

    @DeleteMapping("/signout/{memberUuid}")
    public CommonResponseEntity<Void> signOut(@PathVariable UUID memberUuid,
                                              @RequestHeader("Authorization") String token) {

        authService.signOut(memberUuid);
        return new CommonResponseEntity<>(HttpStatus.OK, true, CommonResponseMessage.SUCCESS.getMessage(), null);
//        String accessToken = token.replace("Bearer ", "");
//        Claims claims = jwtTokenProvider.getClaims(accessToken);
//
//        if (!claims.getSubject().equals(memberUuid.toString())) {
//            return new CommonResponseEntity<>(HttpStatus.UNAUTHORIZED, false, "잘못된 토큰", null);
//        }
//
//        authService.signOut(memberUuid);
//        return new CommonResponseEntity<>(HttpStatus.OK, true, CommonResponseMessage.SUCCESS.getMessage(), null);
    }

    @Operation(summary = "LogIn API", description = "LogIn API", tags = {"Auth"})
    @PostMapping("/login")
    public CommonResponseEntity<LogInResponseVo> logIn(
            @RequestBody LogInRequestVo logInRequestVo) {
        ModelMapper modelMapper = new ModelMapper();
        LogInRequestDto logInRequestDto = LogInRequestDto.builder().
                loginId(logInRequestVo.getLoginId()).
                password(logInRequestVo.getPassword()).
                build();

        LogInResponseVo logInResponseVo = modelMapper.map(authService.logIn(logInRequestDto), LogInResponseVo.class);
        log.info("signInResponseVo : {}", logInResponseVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                logInResponseVo);
    }

//    @PostMapping("/do_user_exist")
//    @PostMapping("/reset_password")

}
