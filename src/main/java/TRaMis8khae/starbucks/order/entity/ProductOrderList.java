package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

@Entity
public class ProductOrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private Long productOptionId;

    private Double productPrice;

    @Column(length = 50)
    private String productName;

    private Integer quantity;

    private String size;

    @Column(length = 50)
    private String engraving;

    private Integer discountPrice;
}
