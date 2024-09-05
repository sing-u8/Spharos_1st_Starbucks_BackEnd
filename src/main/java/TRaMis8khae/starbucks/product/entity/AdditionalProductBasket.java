package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class AdditionalProductBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long additionalProductId;
    private String memberUUID;
    private Integer count;

    @ManyToOne
    private ProductBasket productBasket;
}
