package TRaMis8khae.starbucks.auth.vo;

import lombok.*;

@Getter
@NoArgsConstructor
public class LogInResponseVo {

    private String accessToken;

    private String refreshToken;

    private String memberUUID;

    private String nickname;

    @Builder
    public LogInResponseVo(String accessToken, String refreshToken, String memberUUID, String nickname) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.memberUUID = memberUUID;
        this.nickname = nickname;
    }

}
