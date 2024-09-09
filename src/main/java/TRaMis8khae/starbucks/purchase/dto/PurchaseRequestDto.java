package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.vo.PurchaseRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString(exclude = "purchaseDelivery")
public class PurchaseRequestDto {

    @Column(columnDefinition = "binary(16)")
    private String memberUUID;

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
            String serialNum,
            LocalDateTime purhchaseDate) {
        return PurchaseRequestDto.builder()
                .memberUUID(purchaseRequestVo.getMemberUUID())
                .deliveryPrice(purchaseRequestVo.getDeliveryPrice())
                .totalPrice(purchaseRequestVo.getTotalPrice())
                .cardInfo(purchaseRequestVo.getCardInfo())
                .memberName(purchaseRequestVo.getMemberName())
                .memberPhone(purchaseRequestVo.getMemberPhone())
                .serialNumber(serialNum)
                .purchaseDate(purhchaseDate)
                .build();
    }

    public Purchase toEntity() {
        return Purchase.builder()
                .memberUUID(memberUUID)
                .serialNumber(serialNumber)
                .deliveryPrice(deliveryPrice)
                .totalPrice(totalPrice)
                .cardInfo(cardInfo)
                .memberName(memberName)
                .memberPhone(memberPhone)
                .build();
    }

}