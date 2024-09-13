package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.LogInResponseVo;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
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