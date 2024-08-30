package TRaMis8khae.starbucks.auth.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SignInRequestVo {
    private String loginId;
    private String password;
}
