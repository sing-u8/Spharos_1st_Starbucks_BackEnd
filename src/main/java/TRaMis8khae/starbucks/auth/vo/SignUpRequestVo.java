package TRaMis8khae.starbucks.auth.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class SignUpRequestVo {

    private String name;

    private String loginId;

    private String password;

    private Date birth;

    private String phoneNumber;

    private String email;

    private String nickname;

    private Boolean EmailMarketingConsent;

    private Boolean SMSMarketingConsent;

}