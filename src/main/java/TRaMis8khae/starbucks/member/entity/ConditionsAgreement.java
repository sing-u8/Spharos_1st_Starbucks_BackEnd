package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;

@Entity
public class ConditionsAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conditionsListId;
    private Boolean marketingAgreementChecked;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Conditions conditions;

}
