package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.*;

@Entity
public class Marketing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marketingAgreementId;

    @Column(nullable = false, length = 50)
    private String marketingAgreementName;

    @Column(nullable = false, length = 500)
    private String marketingAgreementContent;

}