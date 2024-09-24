package TRaMis8khae.starbucks.auth.entity;

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

    private String memberUUID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Terms terms;

    @Builder
    public TermsConsentList(Boolean termsConsentChecked, String memberUUID, Terms terms) {
        this.termsConsentChecked = termsConsentChecked;
        this.memberUUID = memberUUID;
        this.terms = terms;
    }

}