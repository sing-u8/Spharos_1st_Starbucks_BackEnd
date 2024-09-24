package TRaMis8khae.starbucks.auth.dto.out;

import TRaMis8khae.starbucks.auth.vo.out.FindMemberResponseVo;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindMemberResponseDto {

    private String loginId;

    @Builder
    public FindMemberResponseDto(String loginId) {
        this.loginId = loginId;
    }

    public static FindMemberResponseDto toDto(Member member) {
        return FindMemberResponseDto.builder()
                .loginId(member.getLoginId())
                .build();
    }

    public FindMemberResponseVo toVo() {
        return FindMemberResponseVo.builder()
                .loginId(loginId)
                .build();
    }

}
