package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.FindMemberRequestVo;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class FindMemberRequestDto {

    private String name;

    private String phoneNumber;

    @Builder
    public FindMemberRequestDto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static FindMemberRequestDto toDto(FindMemberRequestVo findMemberRequestVo) {
        return FindMemberRequestDto.builder()
                .name(findMemberRequestVo.getName())
                .phoneNumber(findMemberRequestVo.getPhoneNumber())
                .build();
    }

}
