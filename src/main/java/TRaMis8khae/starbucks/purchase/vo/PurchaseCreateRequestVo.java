package TRaMis8khae.starbucks.purchase.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PurchaseCreateRequestVo {

    private String memberUUID;

    private Double deliveryPrice; // 상품주문리스트로 이동?

    private Double totalPrice; // 상품주문리스트로 이동?

    private String cardInfo;

    private String memberName;

    private String memberPhone;

}