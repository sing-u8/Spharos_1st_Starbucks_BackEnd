package TRaMis8khae.starbucks.cart.entity;

import jakarta.persistence.*;

@Entity
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberUUID;

    private String productUUID;

    private Integer count;

    private Boolean checked;

    private Boolean deleted;

    private Boolean additionalChecked;

    private Long productOptionId;

    private int quantity;

}
