package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.entity.PurchaseDelivery;
import TRaMis8khae.starbucks.purchase.vo.OrderRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class OrderRequestDto {

    @Column(columnDefinition = "binary(16)")
    private String memberUUID;

    private PurchaseDelivery purchaseDelivery;

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

    public static OrderRequestDto toDto(
            OrderRequestVo orderRequestVo,
            PurchaseDelivery purchaseDelivery,
            String serialNum,
            LocalDateTime orderDate) {
        return OrderRequestDto.builder()
                .memberUUID(orderRequestVo.getMemberUUID())
                .deliveryPrice(orderRequestVo.getDeliveryPrice())
                .totalPrice(orderRequestVo.getTotalPrice())
                .cardInfo(orderRequestVo.getCardInfo())
                .memberName(orderRequestVo.getMemberName())
                .memberPhone(orderRequestVo.getMemberPhone())
                .purchaseDelivery(purchaseDelivery)
                .serialNumber(serialNum)
                .orderDate(orderDate)
                .build();
    }

    public Purchase toEntity() {
        return Purchase.builder()
                .memberUUID(memberUUID)
                .serialNumber(serialNumber)
                .orderDate(orderDate)
                .deliveryPrice(deliveryPrice)
                .totalPrice(totalPrice)
                .cardInfo(cardInfo)
                .memberName(memberName)
                .memberPhone(memberPhone)
                .purchaseDelivery(purchaseDelivery)
                .build();
    }
}
