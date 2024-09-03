package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productOrderId;
    private Double productPrice;
    @Column(length = 50)
    private String productName;
    private Integer quantity;
    private String size;
    @Column(length = 50)
    private String engraving;
    private Integer discountPrice;
    private Long productOptionId;
}
