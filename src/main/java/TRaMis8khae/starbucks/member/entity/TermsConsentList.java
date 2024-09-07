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

    private Boolean checked;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Terms terms;

    @Builder
    public TermsConsentList(Boolean checked, Member member, Terms terms) {
        this.checked = checked;
        this.member = member;
        this.terms = terms;
    }

}