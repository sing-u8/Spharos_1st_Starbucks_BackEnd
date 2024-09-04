package TRaMis8khae.starbucks.order.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "binary(16)")
    private String memberUUID;
    @Column(nullable = false, length = 50)
    private String serialNumber;
    @Column(nullable = false, length = 50)
    private LocalDateTime orderDate;
    private Double deliveryPrice;
    private Double totalPrice;
    private String cardInfo;
    @Column(nullable = false, length = 50)
    private String memberName;
    @Column(nullable = false, length = 50)
    private String memberPhone;

    @OneToOne
    private OrderDeliveryAddressList orderDeliveryAddress;

    @OneToMany
    private ProductOrderList productOrderList;

    @Builder
    public Order(String memberUUID, String serialNumber, LocalDateTime orderDate, Double deliveryPrice, Double totalPrice, String cardInfo, String memberName, String memberPhone) {
        this.memberUUID = memberUUID;
        this.serialNumber = serialNumber;
        this.orderDate = orderDate;
        this.deliveryPrice = deliveryPrice;
        this.totalPrice = totalPrice;
        this.cardInfo = cardInfo;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
    }
}
