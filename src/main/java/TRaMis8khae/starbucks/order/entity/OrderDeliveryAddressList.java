package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDeliveryAddressList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String addressDetail;
    @Column(length = 500)
    private String deliveryMemo;
    @Column(length = 50)
    private String deliveryAddressNickname;
    @Column(nullable = false, length = 50)
    private String recipient;
    private String phone1;
    private String phone2;

}
