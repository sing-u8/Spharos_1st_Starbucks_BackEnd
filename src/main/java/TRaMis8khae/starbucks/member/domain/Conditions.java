package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Conditions {
    @Id
    private Long termId;
    private String termName;
    private String termContent;
}
