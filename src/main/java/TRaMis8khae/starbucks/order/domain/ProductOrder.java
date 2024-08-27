package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductOrder {
    @Id
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
