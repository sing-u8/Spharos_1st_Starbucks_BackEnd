package TRaMis8khae.starbucks.auth.vo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogInResponseVo {

    private String accessToken;

    private String refreshToken;

    private String uuid;

    private String nickname;

}