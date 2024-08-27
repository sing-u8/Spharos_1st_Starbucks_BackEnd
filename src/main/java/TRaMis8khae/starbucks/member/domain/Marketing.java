package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Marketing {
    @Id
    private Long marketingAgreementId;
    @Column(nullable = false, length = 50)
    private String marketingAgreementName;
    @Column(nullable = false, length = 50)
    private String marketingAgreementContent;

}
