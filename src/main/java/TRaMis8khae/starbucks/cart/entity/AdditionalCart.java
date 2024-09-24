package TRaMis8khae.starbucks.cart.entity;

import jakarta.persistence.*;

@Entity
public class AdditionalCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberUUID;

    private String productUUID;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart Cart;

}