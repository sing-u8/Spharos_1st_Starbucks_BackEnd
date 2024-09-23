package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.SignUpRequestVo;
import TRaMis8khae.starbucks.member.dto.AddMarketingConsentListRequestDto;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
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

    @Builder
    public SignUpRequestDto(
            String name,
            String loginId,
            String password,
            Date birth,
            String phoneNumber,
            String email,
            String nickname,
            String address,
            String paymentPassword,
            Boolean marketingConsentEmail,
            Boolean marketingConsentSms
    ) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nickname = nickname;
        this.address = address;
        this.paymentPassword = paymentPassword;
        this.marketingConsentEmail = marketingConsentEmail;
        this.marketingConsentSms = marketingConsentSms;
    }

    public static SignUpRequestDto toDto(SignUpRequestVo signUpRequestVo) {
        return SignUpRequestDto.builder()
                .name(signUpRequestVo.getName())
                .loginId(signUpRequestVo.getLoginId())
                .password(signUpRequestVo.getPassword())
                .birth(signUpRequestVo.getBirth())
                .phoneNumber(signUpRequestVo.getPhoneNumber())
                .email(signUpRequestVo.getEmail())
                .nickname(signUpRequestVo.getNickname())
                .EmailMarketingConsent(signUpRequestVo.getEmailMarketingConsent())
                .SMSMarketingConsent(signUpRequestVo.getSmsMarketingConsent())
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