package TRaMis8khae.starbucks.purchase.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PurchaseAddRequestVo {

    // purchase
    private String memberUUID;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    private String memberName;

    private String memberPhone;

    // deliveryAddress
    private String addressDetail;

    private String deliveryMemo;

    private String recipient;

    private String phone1;

    private String phone2;

    // productOption
    private Double productPrice;

    private String productName;

    private Integer quantity;

    private String size;

    private String engraving;

    private Double discountPrice;

}