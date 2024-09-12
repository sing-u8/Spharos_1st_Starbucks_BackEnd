package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.FindMemberRequestVo;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindMemberRequestDto {

    private String name;

    private String phoneNumber;

    public FindMemberRequestDto toDto(FindMemberRequestVo findMemberRequestVo) {
        return FindMemberRequestDto.builder()
                .name(findMemberRequestVo.getName())
                .phoneNumber(findMemberRequestVo.getPhoneNumber())
                .build();
    }

}
