package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.domain.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignUpDto {

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

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .login_id(loginId)
                .password(password)
                .birth(birth)
                .phone_number(phoneNumber)
                .email(email)
                .nickname(nickname)
                .address(address)
                .payment_password(paymentPassword)
                .build();
    }
}
