package TRaMis8khae.starbucks.auth.dto.out;

import TRaMis8khae.starbucks.auth.vo.out.LogInResponseVo;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class LogInResponseDto {

    private String accessToken;
    private String refreshToken;
    private String nickname;
    private String memberUUID;

    public static LogInResponseDto toDto(Member member, String accessToken, String refreshToken) {
        return LogInResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .nickname(member.getNickname())
                .memberUUID(member.getMemberUUID())
                .build();
    }

    public LogInResponseVo toVo() {
        return LogInResponseVo.builder()
                .nickname(this.nickname)
                .memberUUID(this.memberUUID)
                .accessToken(this.accessToken)
                .refreshToken(this.refreshToken)
                .build();
    }

}