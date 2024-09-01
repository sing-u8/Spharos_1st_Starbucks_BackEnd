package TRaMis8khae.starbucks.auth.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogInResponseVo {

    private String accessToken;
    private String refreshToken;
    private String uuid;
}
