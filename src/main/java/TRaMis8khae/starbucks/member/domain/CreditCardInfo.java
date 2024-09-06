package TRaMis8khae.starbucks.purchase.entity;

import jakarta.persistence.*;
// member로
@Entity
public class CreditCardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String cardName;

    @Column(length = 50)
    private String cardCompany;

    @Column(columnDefinition = "binary(16)")
    private String memberUUID;

}