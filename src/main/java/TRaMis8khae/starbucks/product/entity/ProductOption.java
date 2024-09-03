package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productOptionId;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    @Column(length = 30)
    private String productName;
    private Double price;
    private Integer stockQuantity;
    @Column(length = 30)
    private String productStatus;
    private Integer limitCnt;

    @ManyToOne
    private Engraving engraving;
    @ManyToOne
    private Size size;
}
