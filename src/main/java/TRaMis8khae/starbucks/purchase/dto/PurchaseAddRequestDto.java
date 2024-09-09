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
            LocalDateTime purhchaseDate) {
        return PurchaseAddRequestDto.builder()
                .memberUUID(purchaseAddRequestVo.getMemberUUID())
                .deliveryPrice(purchaseAddRequestVo.getDeliveryPrice())
                .totalPrice(purchaseAddRequestVo.getTotalPrice())
                .cardInfo(purchaseAddRequestVo.getCardInfo())
                .memberName(purchaseAddRequestVo.getMemberName())
                .memberPhone(purchaseAddRequestVo.getMemberPhone())
                .serialNumber(serialNum)
                .purchaseDate(purhchaseDate)
                .build();
    }

    public static Purchase toEntity(PurchaseAddRequestDto dto) {
        return Purchase.builder()
                .memberUUID(dto.getMemberUUID())
                .serialNumber(dto.getSerialNumber())
                .deliveryPrice(dto.getDeliveryPrice())
                .totalPrice(dto.getTotalPrice())
                .cardInfo(dto.getCardInfo())
                .memberName(dto.getMemberName())
                .memberPhone(dto.getMemberPhone())
                .build();
    }

}