package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class AdditionalProductBasket {
    @Id
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
