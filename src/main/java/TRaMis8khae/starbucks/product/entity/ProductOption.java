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

    private Boolean soldOutChecked;

    private Boolean closedChecked;

    private Boolean openChecked;


    @ManyToOne(fetch = FetchType.LAZY)
    private Engraving engraving;

    @ManyToOne(fetch = FetchType.LAZY)
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;
}
