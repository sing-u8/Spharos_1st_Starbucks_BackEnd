package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String addressDetail;

    @Column(length = 500)
    private String deliveryMemo;

    @Column(length = 50)
    private String deliveryAddressNickname;

    @Column(nullable = false, length = 50)
    private String recipient;

    @Column(nullable = false, length = 20)
    private String phone1; // 설정 필요

    @Column(length = 20)
    private String phone2;

    @Builder
    public DeliveryAddress(String addressDetail, String deliveryMemo, String deliveryAddressNickname, String recipient, String phone1, String phone2) {
        this.addressDetail = addressDetail;
        this.deliveryMemo = deliveryMemo;
        this.deliveryAddressNickname = deliveryAddressNickname;
        this.recipient = recipient;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public void updateDeliveryAddress(String addressDetail, String deliveryMemo, String deliveryAddressNickname, String recipient, String phone1, String phone2) {
        this.addressDetail = addressDetail;
        this.deliveryMemo = deliveryMemo;
        this.deliveryAddressNickname = deliveryAddressNickname;
        this.recipient = recipient;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

}