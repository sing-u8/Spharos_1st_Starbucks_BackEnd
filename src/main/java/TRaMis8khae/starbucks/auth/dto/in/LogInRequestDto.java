package TRaMis8khae.starbucks.auth.dto.in;

import TRaMis8khae.starbucks.auth.vo.in.LogInRequestVo;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class LogInRequestDto {

    private String loginId;
    private String password;

    public static LogInRequestDto toDto(LogInRequestVo logInRequestVo) {
        return LogInRequestDto.builder()
                .loginId(logInRequestVo.getLoginId())
                .password(logInRequestVo.getPassword())
                .build();
    }

}