package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ProductInfoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productInfoId;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private Integer imageOrder;
    @Column(length = 20)
    private String imageType;

    @ManyToOne
    private ProductInfo productInfo;
}
