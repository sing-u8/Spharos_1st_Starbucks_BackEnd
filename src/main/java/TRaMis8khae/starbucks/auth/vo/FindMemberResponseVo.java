package TRaMis8khae.starbucks.auth.vo;

import lombok.*;

@Getter
@NoArgsConstructor
public class FindMemberResponseVo {

    private String loginId;

    @Builder
    public FindMemberResponseVo(String loginId) {
        this.loginId = loginId;
    }

}
