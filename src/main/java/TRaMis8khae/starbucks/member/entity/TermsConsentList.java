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

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "terms_id")
    private Terms terms;

    @Builder
    public TermsConsentList(Boolean checked, Member member, Terms terms) {
        this.termsConsentChecked = checked;
        this.member = member;
        this.terms = terms;
    }

}