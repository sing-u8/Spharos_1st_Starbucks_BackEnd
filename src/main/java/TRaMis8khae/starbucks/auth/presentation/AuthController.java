package TRaMis8khae.starbucks.auth.presentation;

import TRaMis8khae.starbucks.auth.application.AuthService;
import TRaMis8khae.starbucks.auth.dto.in.*;
import TRaMis8khae.starbucks.auth.dto.out.FindMemberResponseDto;
import TRaMis8khae.starbucks.auth.dto.out.LogInResponseDto;
import TRaMis8khae.starbucks.auth.dto.out.TermsResponseDto;
import TRaMis8khae.starbucks.auth.vo.in.FindMemberRequestVo;
import TRaMis8khae.starbucks.auth.vo.in.LogInRequestVo;
import TRaMis8khae.starbucks.auth.vo.in.ResetPasswordRequestVo;
import TRaMis8khae.starbucks.auth.vo.in.SignUpRequestVo;
import TRaMis8khae.starbucks.auth.vo.out.FindMemberResponseVo;
import TRaMis8khae.starbucks.auth.vo.out.LogInResponseVo;
import TRaMis8khae.starbucks.auth.vo.in.UpdateMemberInfoRequestVo;
import TRaMis8khae.starbucks.auth.infrastructure.AuthRepository;
import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.vo.out.TermsResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입 API", description = "SignUp API 아이디, 비밀번호, 이름, 이메일 필수 입력", tags = {"Auth"})
    @PostMapping("/signup")
    public BaseResponse<Void> SignUp(@RequestBody SignUpRequestVo signUpRequestVo) {

        SignUpRequestDto signUpRequestDto = SignUpRequestDto.toDto(signUpRequestVo);

        authService.signUp(signUpRequestDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }

    @Operation(summary = "로그인 API", description = "logIn API", tags = {"Auth"})
    @PostMapping("/login")
    public BaseResponse<LogInResponseVo> logIn(@RequestBody LogInRequestVo logInRequestVo) {

        LogInRequestDto logInRequestDto = LogInRequestDto.toDto(logInRequestVo);

        LogInResponseDto logInResponseDto = authService.logIn(logInRequestDto);

        LogInResponseVo logInResponseVo = logInResponseDto.toVo();

        return new BaseResponse<>(
                logInResponseVo
        );

    }

    @Operation(summary = "회원탈퇴 API", description = "signOut API", tags = {"Auth"})
    @DeleteMapping("/signout")
    public BaseResponse<Void> signOut(Authentication authentication) {

        authService.signOut(authentication.getName());

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }

    @Operation(summary = "회원 정보 수정 API", description = "updateMemberInfo API", tags = {"Auth"})
    @PutMapping("/member_info")
    public BaseResponse<Void> updateMemberInfo(Authentication authentication,
                                                       @RequestBody UpdateMemberInfoRequestVo UpdateMemberInfoRequestVo) {

        UpdateMemberInfoRequestDto updateMemberInfoRequestDto = UpdateMemberInfoRequestDto
                .toDto(UpdateMemberInfoRequestVo);

        authService.updateMemberInfo(authentication.getName(), updateMemberInfoRequestDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }

    @Operation(summary = "회원 찾기 API", description = "findMember API", tags = {"Auth"})
    @PostMapping("/find_member")
    public BaseResponse<FindMemberResponseVo> findMember(@RequestBody FindMemberRequestVo findMemberRequestVo) {

        FindMemberRequestDto findMemberRequestDto = FindMemberRequestDto.toDto(findMemberRequestVo);

        FindMemberResponseDto findMemberResponseDto = authService.findMember(findMemberRequestDto);

        FindMemberResponseVo findMemberResponseVo = findMemberResponseDto.toVo();

        return new BaseResponse<>(findMemberResponseVo);

    }

    @Operation(summary = "비밀번호 변경 API", description = "resetPassword API", tags = {"Auth"})
    @PutMapping("/reset_password") // 본인 인증에 관한 처리로 인해 보류
    public BaseResponse<Void> resetPassword(@RequestBody ResetPasswordRequestVo resetPasswordRequestVo) {

        ResetPasswordRequestDto resetPasswordRequestDto = ResetPasswordRequestDto.toDto(resetPasswordRequestVo);

        authService.resetPassword(resetPasswordRequestDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }

    @Operation(summary = "약관 동의 조회 API", description = "getTermsConsentList API", tags = {"Auth"})
    @GetMapping("terms")
    public BaseResponse<List<TermsResponseVo>> getTermsConsentList() {
        List<TermsResponseDto> termsConsentList = authService.getTermsConsentList();

        List<TermsResponseVo> responseVos = termsConsentList
                .stream().map(TermsResponseDto::toVo).toList();

        return new BaseResponse<>(
                responseVos
        );
    }

}