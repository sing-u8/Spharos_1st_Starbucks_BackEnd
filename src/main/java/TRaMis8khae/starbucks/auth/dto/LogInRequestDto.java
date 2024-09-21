package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.LogInRequestVo;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class LogInRequestDto {

    private String loginId;
    private String password;

    @Builder
    public LogInRequestDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public static LogInRequestDto toDto(LogInRequestVo logInRequestVo) {
        return LogInRequestDto.builder()
                .loginId(logInRequestVo.getLoginId())
                .password(logInRequestVo.getPassword())
                .build();
    }

}