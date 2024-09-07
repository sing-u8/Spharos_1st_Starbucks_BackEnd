package TRaMis8khae.starbucks.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogInResponseDto {

    private String accessToken;
    private String refreshToken;
    private String nickname;
    private String memberUUID;

}