package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.vo.PurchaseAddRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PurchaseAddRequestDto {

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

    public static PurchaseAddRequestDto toDto(
            PurchaseAddRequestVo purchaseAddRequestVo,
            String serialNum,
            LocalDateTime purchaseDate) {
        return PurchaseAddRequestDto.builder()
                .memberUUID(purchaseAddRequestVo.getMemberUUID())
                .deliveryPrice(purchaseAddRequestVo.getDeliveryPrice())
                .totalPrice(purchaseAddRequestVo.getTotalPrice())
                .cardInfo(purchaseAddRequestVo.getCardInfo())
                .memberName(purchaseAddRequestVo.getMemberName())
                .memberPhone(purchaseAddRequestVo.getMemberPhone())
                .serialNumber(serialNum)
                .purchaseDate(purchaseDate)
                .build();
    }

    public Purchase toEntity() {
        return Purchase.builder()
                .memberUUID(this.memberUUID)
                .serialNumber(this.serialNumber)
                .deliveryPrice(this.deliveryPrice)
                .totalPrice(this.totalPrice)
                .cardInfo(this.cardInfo)
                .memberName(this.memberName)
                .memberPhone(this.memberPhone)
                .build();
    }

}