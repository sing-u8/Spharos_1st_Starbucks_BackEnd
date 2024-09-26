package TRaMis8khae.starbucks.auth.dto.in;

import TRaMis8khae.starbucks.auth.entity.TermsConsentList;
import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.auth.entity.Terms;
import TRaMis8khae.starbucks.member.vo.in.AddTermsConsentListRequestVo;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class TermsConsentListAddRequestDto {

    private boolean termsConsentChecked;
    private String memberUUID;

    public static TermsConsentListAddRequestDto toDto(AddTermsConsentListRequestVo requestVo) {
        return TermsConsentListAddRequestDto.builder()
                .termsConsentChecked(requestVo.isChecked())
                .memberUUID(requestVo.getMemberUUID())
                .build();
    }

//    public TermsConsentList toEntity(Member member, Terms terms) {
//        return TermsConsentList.builder()
//                .termsConsentChecked(this.termsConsentChecked)
//                .terms(terms)
//                .member(member)
//                .build();
//    }

}
