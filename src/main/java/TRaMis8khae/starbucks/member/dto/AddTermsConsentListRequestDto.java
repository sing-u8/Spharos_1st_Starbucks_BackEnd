package TRaMis8khae.starbucks.member.dto;

import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.entity.Terms;
import TRaMis8khae.starbucks.member.entity.TermsConsentList;
import TRaMis8khae.starbucks.member.vo.AddTermsConsentListRequestVo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddTermsConsentListRequestDto {

    private boolean termsConsentChecked;
    private String memberUUID;

    @Builder
    public AddTermsConsentListRequestDto(boolean termsConsentChecked, String memberUUID) {
        this.termsConsentChecked = termsConsentChecked;
        this.memberUUID = memberUUID;
    }

    public static AddTermsConsentListRequestDto toDto(AddTermsConsentListRequestVo requestVo) {
        return AddTermsConsentListRequestDto.builder()
                .termsConsentChecked(requestVo.isChecked())
                .memberUUID(requestVo.getMemberUUID())
                .build();
    }

    public TermsConsentList toEntity(Member member, Terms terms) {
        return TermsConsentList.builder()
                .termsConsentChecked(this.termsConsentChecked)
                .terms(terms)
                .member(member)
                .build();
    }

}
