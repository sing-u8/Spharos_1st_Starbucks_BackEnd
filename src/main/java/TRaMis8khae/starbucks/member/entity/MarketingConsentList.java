package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class MarketingConsentList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean marketingConsentChecked;

    @ManyToOne
    private Marketing marketing;

    @ManyToOne
    private Member member;

    @Builder
    public MarketingConsentList(Boolean marketingAgreementChecked, Marketing marketing, Member member) {
        this.marketingConsentChecked = marketingAgreementChecked;
        this.marketing = marketing;
        this.member = member;
    }
}
