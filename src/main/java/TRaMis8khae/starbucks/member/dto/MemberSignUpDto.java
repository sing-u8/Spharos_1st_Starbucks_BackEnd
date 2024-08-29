package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.domain.Member;
import lombok.Builder;
import lombok.Setter;

import java.util.Date;

@Setter
@Builder
public class MemberSignUpDto {

    private Long member_id;
    private String name;
    private String login_id;
    private String password;
    private Date birth;
    private String phone_number;
    private String email;
    private String nickname;
    private String address;
    private String payment_password;
    private Boolean member_status;

    public Member toEntity() {
        return Member.builder()
                .member_id(member_id)
                .name(name)
                .login_id(login_id)
                .password(password)
                .birth(birth)
                .phone_number(phone_number)
                .email(email)
                .nickname(nickname)
                .address(address)
                .payment_password(payment_password)
                .member_status(member_status)
                .build();
    }

}
