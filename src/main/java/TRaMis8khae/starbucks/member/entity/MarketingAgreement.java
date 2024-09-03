package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;

@Entity
public class MarketingAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marketingListId;
    private Boolean marketingAgreementChecked;

    @ManyToOne
    private Marketing marketing;
    @ManyToOne
    private Member member;
}
