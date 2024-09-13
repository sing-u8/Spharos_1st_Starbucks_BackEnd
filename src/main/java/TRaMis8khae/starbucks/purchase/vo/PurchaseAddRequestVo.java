package TRaMis8khae.starbucks.purchase.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PurchaseAddRequestVo {

    private String memberUUID;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    private String memberName;

    private String memberPhone;

}