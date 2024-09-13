package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.LogInRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
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