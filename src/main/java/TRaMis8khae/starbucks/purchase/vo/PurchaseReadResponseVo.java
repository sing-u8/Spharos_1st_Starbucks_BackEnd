package TRaMis8khae.starbucks.purchase.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PurchaseReadResponseVo {

    @Column(nullable = false, length = 50)
    private String serialNumber;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    @Column(nullable = false, length = 50)
    private String memberName;

    @Column(nullable = false, length = 50)
    private String memberPhone;

    @Column(length = 50)
    private String addressDetail;

    @Column(length = 500)
    private String deliveryMemo;

    @Column(length = 50)
    private String deliveryAddressNickname;

    //    @Column(nullable = false, length = 50)
    private String recipient;

    private String phone1;

    private String phone2;

}