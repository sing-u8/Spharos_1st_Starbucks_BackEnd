package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.entity.PurchaseDelivery;
import TRaMis8khae.starbucks.purchase.vo.PurchaseRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PurchaseRequestDto {

    @Column(columnDefinition = "binary(16)")
    private String memberUUID;

    private PurchaseDelivery purchaseDelivery;

    @Column(nullable = false, length = 50)
    private String serialNumber;

    @Column(nullable = false, length = 50)
    private LocalDateTime purchaseDate;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    @Column(nullable = false, length = 50)
    private String memberName;

    @Column(nullable = false, length = 50)
    private String memberPhone;

    public static PurchaseRequestDto toDto(
            PurchaseRequestVo purchaseRequestVo,
            PurchaseDelivery purchaseDelivery,
            String serialNum,
            LocalDateTime purhchaseDate) {
        return PurchaseRequestDto.builder()
                .memberUUID(purchaseRequestVo.getMemberUUID())
                .deliveryPrice(purchaseRequestVo.getDeliveryPrice())
                .totalPrice(purchaseRequestVo.getTotalPrice())
                .cardInfo(purchaseRequestVo.getCardInfo())
                .memberName(purchaseRequestVo.getMemberName())
                .memberPhone(purchaseRequestVo.getMemberPhone())
                .purchaseDelivery(purchaseDelivery)
                .serialNumber(serialNum)
                .purchaseDate(purhchaseDate)
                .build();
    }

    public Purchase toEntity() {
        return Purchase.builder()
                .memberUUID(memberUUID)
                .serialNumber(serialNumber)
                .purchaseDate(purchaseDate)
                .deliveryPrice(deliveryPrice)
                .totalPrice(totalPrice)
                .cardInfo(cardInfo)
                .memberName(memberName)
                .memberPhone(memberPhone)
                .purchaseDelivery(purchaseDelivery)
                .build();
    }

}