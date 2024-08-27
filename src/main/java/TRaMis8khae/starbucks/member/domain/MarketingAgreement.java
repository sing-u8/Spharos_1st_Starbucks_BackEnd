package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MarketingAgreement {
    @Id
    private Long marketingListId;
    private Boolean marketingAgreementChecked;

    @ManyToOne
    private Marketing marketing;
    @ManyToOne
    private Member member;
}
