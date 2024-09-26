package TRaMis8khae.starbucks.auth.dto.in;

import TRaMis8khae.starbucks.auth.vo.in.FindMemberRequestVo;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class FindMemberRequestDto {

    private String name;

    private String phoneNumber;

    public static FindMemberRequestDto toDto(FindMemberRequestVo findMemberRequestVo) {
        return FindMemberRequestDto.builder()
                .name(findMemberRequestVo.getName())
                .phoneNumber(findMemberRequestVo.getPhoneNumber())
                .build();
    }

}
