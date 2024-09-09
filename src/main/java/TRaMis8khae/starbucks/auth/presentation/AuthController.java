package TRaMis8khae.starbucks.auth.presentation;

import TRaMis8khae.starbucks.auth.application.AuthService;
import TRaMis8khae.starbucks.auth.dto.*;
import TRaMis8khae.starbucks.auth.vo.*;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.common.jwt.JwtAuthenticationFilter;
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
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Operation(summary = "SignIn API", description = "SignUp API", tags = {"Auth"})
    @PostMapping("/signin")
    public CommonResponseEntity<SignInResponseVo> signIn(@RequestBody SignInRequestVo signInRequestVo) {

        SignInRequestDto signInRequestDto = SignInRequestDto.builder().
                name(signInRequestVo.getName()).
                loginId(signInRequestVo.getLoginId()).
                password(signInRequestVo.getPassword()).
                birth(signInRequestVo.getBirth()).
                nickname(signInRequestVo.getNickname()).
                paymentPassword(signInRequestVo.getPaymentPassword()).
                address(signInRequestVo.getAddress()).
                email(signInRequestVo.getEmail()).
                phoneNumber(signInRequestVo.getPhoneNumber()).
                build();

        SignInResponseDto signInResponseDto = authService.signIn(signInRequestDto);

        SignInResponseVo signInResponseVo = SignInResponseVo.builder().
                nickname(signInRequestVo.getNickname()).
                build();

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                signInResponseVo);

    }

    @DeleteMapping("/signout/{memberUUID}")
    public CommonResponseEntity<Void> signOut(
            @PathVariable String memberUUID,
            @RequestHeader("Authorization") String token) {

        String accessToken = token.replace("Bearer ", "");

        Claims claims = jwtTokenProvider.getClaims(accessToken);

        String memberUuidFromToken = claims.get("memberUUID", String.class);

        if (!memberUUID.equals(memberUuidFromToken)) {
            return new CommonResponseEntity<>(HttpStatus.UNAUTHORIZED, false, "잘못된 UUID", null);
        }

        authService.signOut(memberUUID, accessToken);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

    @Operation(summary = "LogIn API", description = "LogIn API", tags = {"Auth"})
    @PostMapping("/login")
    public CommonResponseEntity<LogInResponseVo> logIn(@RequestBody LogInRequestVo logInRequestVo) {

        LogInRequestDto logInRequestDto = LogInRequestDto.builder().
                loginId(logInRequestVo.getLoginId()).
                password(logInRequestVo.getPassword()).
                build();

        LogInResponseDto logInResponseDto = authService.logIn(logInRequestDto);

        LogInResponseVo logInResponseVo = LogInResponseVo.builder().
                accessToken(logInResponseDto.getAccessToken()).
                refreshToken(logInResponseDto.getRefreshToken()).
                memberUUID(logInResponseDto.getMemberUUID()).
                nickname(logInResponseDto.getNickname()).
                build();

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                logInResponseVo);
    }

    @PutMapping("/member_info/{memberUUID}")
    public CommonResponseEntity<Void> updateMemberInfo(@RequestHeader("Authorization") String accessToken,
                                                       @PathVariable String memberUUID,
                                                       @RequestBody ModifyMemberInfoRequestVo modifyMemberInfoRequestVo) {

        String token = accessToken.replace("Bearer ", "");

        Claims claims = jwtTokenProvider.getClaims(token);

        String memberUuidFromToken = claims.get("memberUUID", String.class);

        if (!memberUUID.equals(memberUuidFromToken)) {
            return new CommonResponseEntity<>(HttpStatus.UNAUTHORIZED, false, "잘못된 UUID", null);
        }

        ModifyMemberInfoRequestDto modifyMemberInfoRequestDto = ModifyMemberInfoRequestDto.builder()
                .nickname(modifyMemberInfoRequestVo.getNickname())
                .phoneNumber(modifyMemberInfoRequestVo.getPhoneNumber())
                .build();

        try {
            authService.updateMemberInfo(memberUUID, token, modifyMemberInfoRequestDto);
            return new CommonResponseEntity<>(HttpStatus.OK,
                    true,
                    CommonResponseMessage.SUCCESS.getMessage(),
                    null);
        } catch (Exception e) {
            return new CommonResponseEntity<>(HttpStatus.BAD_REQUEST,
                    false,
                    e.getMessage(),
                    null);
        }
    }

    @PostMapping("/find_member")
    public CommonResponseEntity<FindMemberResponseVo> findMember(@RequestBody FindMemberRequestVo findMemberRequestVo) {

        FindMemberRequestDto findMemberRequestDto = FindMemberRequestDto.builder()
                .name(findMemberRequestVo.getName())
                .phoneNumber(findMemberRequestVo.getPhoneNumber())
                .build();

        FindMemberResponseDto findMemberResponseDto = authService.findMember(findMemberRequestDto);

        FindMemberResponseVo findMemberResponseVo = FindMemberResponseVo.builder()
                .loginId(findMemberResponseDto.getLoginId())
                .build();

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                findMemberResponseVo);
    }

}