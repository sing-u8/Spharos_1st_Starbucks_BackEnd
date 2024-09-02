package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "`order`")  // order는 예약어이므로 백틱으로 감싸줌
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    @Column(nullable = false, length = 50)
    private String serialNumber;
    @Column(nullable = false, length = 50)
    private LocalDateTime orderDatetime;
    private Double deliveryCharge;
    private Double totalPrice;
    private String payInfo;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String phoneNumber;

    @OneToOne
    private OrderDeliveryAddress orderDeliveryAddress;
    @OneToOne
    private ProductOrder productOrder;
}
