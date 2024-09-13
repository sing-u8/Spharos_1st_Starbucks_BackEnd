package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;

@Entity
public class CreditCardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String cardName;

    @Column(length = 50)
    private String cardCompany;

    private String memberUUID;

}