package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ProductBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberId;
    private Integer count;
    private Boolean purchaseChecked;
    private Boolean checked;
}
