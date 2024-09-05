package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class ProductBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberUUID;
    private Integer count;
    private Boolean checked;
}
