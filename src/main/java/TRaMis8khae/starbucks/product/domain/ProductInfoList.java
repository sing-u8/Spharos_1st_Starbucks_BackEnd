package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ProductInfoList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
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
