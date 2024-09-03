package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

@Entity
public class CreditCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditCardId;
    @Column(nullable = false, length = 50)
    private String card_name;
    @Column(length = 50)
    private String cardCo;
    @Column(columnDefinition = "binary(16)")
    private String memberUUID;
}
