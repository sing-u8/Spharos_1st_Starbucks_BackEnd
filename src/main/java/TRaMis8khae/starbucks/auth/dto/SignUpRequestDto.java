package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.SignUpRequestVo;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
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
    private Boolean marketingConsentEmail;
    private Boolean marketingConsentSms;

    public static SignUpRequestDto toDto(SignUpRequestVo signUpRequestVo) {
        return SignUpRequestDto.builder()
                .name(signUpRequestVo.getName())
                .loginId(signUpRequestVo.getLoginId())
                .password(signUpRequestVo.getPassword())
                .birth(signUpRequestVo.getBirth())
                .phoneNumber(signUpRequestVo.getPhoneNumber())
                .email(signUpRequestVo.getEmail())
                .nickname(signUpRequestVo.getNickname())
                .marketingConsentEmail(signUpRequestVo.getEmailMarketingConsent())
                .marketingConsentSms(signUpRequestVo.getSMSMarketingConsent())
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
                .address(address)
                .paymentPassword(paymentPassword)
                .memberStatus(Boolean.TRUE)
                .build();
    }

}