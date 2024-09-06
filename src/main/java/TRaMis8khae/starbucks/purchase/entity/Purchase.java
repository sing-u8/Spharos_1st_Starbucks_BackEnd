package TRaMis8khae.starbucks.purchase.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Purchase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String serialNumber;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    @Column(nullable = false, length = 50)
    private String memberName;

    @Column(nullable = false, length = 50)
    private String memberPhone;

    @OneToOne(fetch = FetchType.LAZY)
    private PurchaseDelivery purchaseDelivery;

    @OneToMany(mappedBy = "purchase") // 이미 내가 줬음
    private List<PurchaseProductList> purchaseProductList = new ArrayList<>();

    @Builder
    public Purchase(
            String memberUUID, String serialNumber, LocalDateTime orderDate, Double deliveryPrice, Double totalPrice,
            String cardInfo, String memberName, String memberPhone, PurchaseDelivery purchaseDelivery) {
        this.memberUUID = memberUUID;
        this.serialNumber = serialNumber;
        this.deliveryPrice = deliveryPrice;
        this.totalPrice = totalPrice;
        this.cardInfo = cardInfo;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.purchaseDelivery = purchaseDelivery;
    }
}
