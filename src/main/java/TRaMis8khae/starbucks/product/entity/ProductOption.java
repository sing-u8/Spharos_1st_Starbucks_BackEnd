package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;


@Entity
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productUUID;
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
