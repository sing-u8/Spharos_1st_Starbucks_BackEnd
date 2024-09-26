package TRaMis8khae.starbucks.auth.dto.out;

import TRaMis8khae.starbucks.auth.vo.out.FindMemberResponseVo;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class FindMemberResponseDto {

    private String loginId;

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
