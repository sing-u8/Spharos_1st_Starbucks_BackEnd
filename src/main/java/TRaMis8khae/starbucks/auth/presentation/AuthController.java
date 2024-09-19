package TRaMis8khae.starbucks.auth.presentation;

import TRaMis8khae.starbucks.auth.application.AuthService;
import TRaMis8khae.starbucks.auth.dto.*;
import TRaMis8khae.starbucks.auth.vo.*;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @Parameter(name = "signUpRequestVo", description = "이름, 로그인아이디, 비밀번호, 이메일 필수", required = true)
    @PostMapping("/signup")
    public CommonResponseEntity<Void> SignUp(@RequestBody SignUpRequestVo signUpRequestVo) {

        SignUpRequestDto signUpRequestDto = SignUpRequestDto.toDto(signUpRequestVo);

        authService.signUp(signUpRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

    @DeleteMapping("/signout/{memberUUID}")
    public CommonResponseEntity<Void> signOut(
            @PathVariable String memberUUID,
            @RequestHeader("Authorization") String accessToken) {

        String memberUuidFromToken = jwtTokenProvider.getMemberUUID(accessToken);

        authService.signOut(memberUUID, memberUuidFromToken);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

    @PostMapping("/login")
    public CommonResponseEntity<LogInResponseVo> logIn(@RequestBody LogInRequestVo logInRequestVo) {

        LogInRequestDto logInRequestDto = LogInRequestDto.toDto(logInRequestVo);

        LogInResponseDto logInResponseDto = authService.logIn(logInRequestDto);

        LogInResponseVo logInResponseVo = logInResponseDto.toVo();

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                logInResponseVo);

    }

    @PutMapping("/member_info/{memberUUID}")
    public CommonResponseEntity<Void> updateMemberInfo(@RequestHeader("Authorization") String accessToken,
                                                       @PathVariable String memberUUID,
                                                       @RequestBody UpdateMemberInfoRequestVo UpdateMemberInfoRequestVo) {

        UpdateMemberInfoRequestDto updateMemberInfoRequestDto = UpdateMemberInfoRequestDto
                .toDto(UpdateMemberInfoRequestVo);

        authService.updateMemberInfo(memberUUID, accessToken, updateMemberInfoRequestDto);

        return new CommonResponseEntity<>(HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

    @PostMapping("/find_member")
    public CommonResponseEntity<FindMemberResponseVo> findMember(@RequestBody FindMemberRequestVo findMemberRequestVo) {

        FindMemberRequestDto findMemberRequestDto = FindMemberRequestDto.toDto(findMemberRequestVo);

        FindMemberResponseDto findMemberResponseDto = authService.findMember(findMemberRequestDto);

        FindMemberResponseVo findMemberResponseVo = findMemberResponseDto.toVo();

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                findMemberResponseVo);

    }

    @Parameter(name = "resetPassword", description = "본인 인증 처리로 인해 보류", required = true)
    @PutMapping("/reset_password") // 본인 인증에 관한 처리로 인해 보류
    public CommonResponseEntity<Void> resetPassword(@RequestBody ResetPasswordRequestVo resetPasswordRequestVo) {

        ResetPasswordRequestDto resetPasswordRequestDto = ResetPasswordRequestDto.toDto(resetPasswordRequestVo);

        authService.resetPassword(resetPasswordRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

}