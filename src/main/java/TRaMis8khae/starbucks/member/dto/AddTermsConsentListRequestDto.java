package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.Terms;
import TRaMis8khae.starbucks.member.entity.TermsConsentList;
import TRaMis8khae.starbucks.member.vo.AddTermsConsentListRequestVo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddTermsConsentListRequestDto {

    private boolean checked;

    public static AddTermsConsentListRequestDto toDto(AddTermsConsentListRequestVo requestVo) {
        return AddTermsConsentListRequestDto.builder()
                .checked(requestVo.isChecked())
                .build();
    }

    public TermsConsentList toEntity(AddTermsConsentListRequestDto requestDto) {
        return TermsConsentList.builder()
                .checked(requestDto.isChecked())
                .build();
    }

}
