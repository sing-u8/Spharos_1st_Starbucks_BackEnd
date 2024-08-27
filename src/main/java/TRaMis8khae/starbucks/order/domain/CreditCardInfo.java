package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class CreditCardInfo {
    @Id
    private Long creditCardId;
    @Column(nullable = false, length = 50)
    private String card_name;
    @Column(length = 50)
    private String cardCo;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuId;
}
