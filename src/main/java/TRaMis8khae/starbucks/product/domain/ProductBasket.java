package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class ProductBasket {
    @Id
    private Long basketId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberId;
    private Integer count;
    private Boolean purchaseChecked;
    private Boolean checked;
}
