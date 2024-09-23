package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class TermsConsentList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean termsConsentChecked;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Terms terms;

    @Builder
    public TermsConsentList(Boolean termsConsentChecked, Member member, Terms terms) {
        this.termsConsentChecked = termsConsentChecked;
        this.member = member;
        this.terms = terms;
    }

}