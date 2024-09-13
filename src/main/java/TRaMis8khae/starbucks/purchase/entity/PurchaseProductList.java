package TRaMis8khae.starbucks.purchase.entity;

import jakarta.persistence.*;

@Entity
public class PurchaseProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productOptionId;

    private Double productPrice;

    @Column(length = 50)
    private String productName;

    private Integer quantity;

    private String size;

    @Column(length = 50)
    private String engraving;

    private Integer discountPrice;

    private Boolean reviewChecked;

    @ManyToOne(fetch = FetchType.LAZY) // sql을 한번 더 날림
    private Purchase purchase;

}