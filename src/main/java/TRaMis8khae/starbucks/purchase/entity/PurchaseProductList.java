package TRaMis8khae.starbucks.purchase.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
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

    private Double discountPrice;

    private Boolean reviewChecked;

    private Long purchaseSerialNumber;

    @Builder
    public PurchaseProductList(
            Long productOptionId, Double productPrice, String productName, Integer quantity,
            String size, String engraving, Double discountPrice, Boolean reviewChecked, Long purchaseSerialNumber) {
        this.productOptionId = productOptionId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.quantity = quantity;
        this.size = size;
        this.engraving = engraving;
        this.discountPrice = discountPrice;
        this.reviewChecked = reviewChecked;
        this.purchaseSerialNumber = purchaseSerialNumber;
    }
}