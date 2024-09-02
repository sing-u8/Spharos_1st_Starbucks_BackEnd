package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class AdditionalProductBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AdditionalBasketId;
    private Long additionalProductId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    private Integer count;
    private Boolean billChecked;
    private Boolean checked;

    @ManyToOne
    private ProductBasket productBasket;
}
