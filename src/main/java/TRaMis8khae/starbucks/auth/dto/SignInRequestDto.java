package TRaMis8khae.starbucks.auth.dto;

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
public class SignInRequestDto {

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
    private String UUID;

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
                .memberUUID(UUID)
                .build();
    }

}