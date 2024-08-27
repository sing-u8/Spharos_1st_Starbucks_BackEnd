package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ConditionsAgreement {
    @Id
    private Long conditionsListId;
    private Boolean marketingAgreementChecked;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Conditions conditions;

}
