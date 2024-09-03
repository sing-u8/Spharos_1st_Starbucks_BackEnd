package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(columnDefinition = "binary(16)")
    private String memberUUID;
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
    private OrderDeliveryAddressList orderDeliveryAddress;
    @OneToOne
    private ProductOrder productOrder;
}
