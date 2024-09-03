package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productInfoId;
    @Column(columnDefinition = "text")
    private String productInfo;
    @Column(length = 20)
    private String productInfoType;
}
