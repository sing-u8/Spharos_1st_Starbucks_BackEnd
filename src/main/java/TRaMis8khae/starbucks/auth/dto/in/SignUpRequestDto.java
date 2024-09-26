package TRaMis8khae.starbucks.auth.dto.in;

import TRaMis8khae.starbucks.auth.vo.in.SignUpRequestVo;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Date;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class SignUpRequestDto {

    private String name;
    private String loginId;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String phoneNumber;
    private String email;
    private String nickname;
    private String address;
    private String paymentPassword;
    private Boolean EmailMarketingConsent;
    private Boolean SMSMarketingConsent;

    public static SignUpRequestDto toDto(SignUpRequestVo signUpRequestVo) {
        return SignUpRequestDto.builder()
                .name(signUpRequestVo.getName())
                .loginId(signUpRequestVo.getLoginId())
                .password(signUpRequestVo.getPassword())
                .birth(signUpRequestVo.getBirth())
                .phoneNumber(signUpRequestVo.getPhoneNumber())
                .email(signUpRequestVo.getEmail())
                .nickname(signUpRequestVo.getNickname())
                .build();
    }


    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .name(name)
                .loginId(loginId)
                .password(passwordEncoder.encode(password))
                .birth(birth)
                .phoneNumber(phoneNumber)
                .email(email)
                .nickname(nickname)
                .memberStatus(Boolean.TRUE)
                .build();
    }

}