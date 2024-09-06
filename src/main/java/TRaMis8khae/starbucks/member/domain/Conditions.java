package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.*;

@Entity
public class Conditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    private String termName;

    @Column(length = 500)
    private String termContent;

}