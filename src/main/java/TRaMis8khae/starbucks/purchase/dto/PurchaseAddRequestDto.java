package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.entity.PurchaseProductList;
import TRaMis8khae.starbucks.purchase.vo.PurchaseAddRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PurchaseAddRequestDto {

    // purchase
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

    // deliveryAddress
    @Column(length = 50)
    private String addressDetail;

    @Column(length = 500)
    private String deliveryMemo;

    //    @Column(nullable = false, length = 50)
    private String recipient;

    private String phone1;

    private String phone2;

    // productOption
    private Double productPrice;

    @Column(length = 50)
    private String productName;

    private Integer quantity;

    private String size;

    @Column(length = 50)
    private String engraving;

    private Double discountPrice;

    public static PurchaseAddRequestDto toDto(
            PurchaseAddRequestVo requestVo,
            String serialNum,
            LocalDateTime purchaseDate) {
        return PurchaseAddRequestDto.builder()
                .memberUUID(requestVo.getMemberUUID())
                .deliveryPrice(requestVo.getDeliveryPrice())
                .totalPrice(requestVo.getTotalPrice())
                .cardInfo(requestVo.getCardInfo())
                .memberName(requestVo.getMemberName())
                .memberPhone(requestVo.getMemberPhone())

                .addressDetail(requestVo.getAddressDetail())
                .deliveryMemo(requestVo.getDeliveryMemo())
                .recipient(requestVo.getRecipient())
                .phone1(requestVo.getPhone1())
                .phone2(requestVo.getPhone2())

                .productPrice(requestVo.getProductPrice())
                .productName(requestVo.getProductName())
                .quantity(requestVo.getQuantity())
                .size(requestVo.getSize())
                .engraving(requestVo.getEngraving())
                .discountPrice(requestVo.getDiscountPrice())

                .serialNumber(serialNum)
                .purchaseDate(purchaseDate)
                .build();
    }

    public Purchase toPurchase() {
        return Purchase.builder()
                .memberUUID(this.memberUUID)
                .serialNumber(this.serialNumber)
                .deliveryPrice(this.deliveryPrice)
                .totalPrice(this.totalPrice)
                .cardInfo(this.cardInfo)
                .memberName(this.memberName)
                .memberPhone(this.memberPhone)

                .addressDetail(this.addressDetail)
                .deliveryMemo(this.deliveryMemo)
                .recipient(this.recipient)
                .phone1(this.phone1)
                .phone2(this.phone2)

                .build();
    }

    public PurchaseProductList toPurchaseProductList() {
        return PurchaseProductList.builder()
                .productOptionId(null)
                .productPrice(this.productPrice)
                .productName(this.productName)
                .quantity(this.quantity)
                .size(this.size)
                .engraving(this.engraving)
                .discountPrice(this.discountPrice)
                .reviewChecked(false)
                .purchaseSerialNumber(null)
                .build();
    }

}