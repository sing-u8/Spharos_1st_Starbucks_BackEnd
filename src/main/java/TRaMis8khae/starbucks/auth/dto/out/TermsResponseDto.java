package TRaMis8khae.starbucks.auth.dto.out;

import TRaMis8khae.starbucks.auth.entity.Terms;
import TRaMis8khae.starbucks.member.vo.out.TermsResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class TermsResponseDto {

    private String termsName;
    private String termsContent;

    public static TermsResponseDto toDto(Terms terms) {
        return TermsResponseDto.builder()
                .termsName(terms.getTermName())
                .termsContent(terms.getTermContent())
                .build();
    }

    public TermsResponseVo toVo() {
        return TermsResponseVo.builder()
                .termsName(this.termsName)
                .termsContent(this.termsContent)
                .build();
    }

}
