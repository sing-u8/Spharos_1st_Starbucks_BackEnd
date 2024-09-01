package TRaMis8khae.starbucks.auth.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@ToString
@Getter
public class SignUpRequestVo {
    private Long memberId;
    private UUID memberUuid;
    private String name;
    private String loginId;
    private String password;
    private Date birth;
    private String phoneNumber;
    private String email;
    private String nickname;
    private String address;
    private String paymentPassword;
    private Boolean memberStatus;
}
