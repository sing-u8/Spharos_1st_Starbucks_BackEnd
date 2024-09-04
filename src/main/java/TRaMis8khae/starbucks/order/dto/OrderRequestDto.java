package TRaMis8khae.starbucks.order.dto;

import TRaMis8khae.starbucks.order.entity.Order;
import TRaMis8khae.starbucks.order.entity.OrderDeliveryAddressList;
import TRaMis8khae.starbucks.order.vo.OrderRequestVo;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class OrderRequestDto {

    @Column(columnDefinition = "binary(16)")
    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String serialNumber;

    @Column(nullable = false, length = 50)
    private LocalDateTime orderDate;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    @Column(nullable = false, length = 50)
    private String memberName;

    @Column(nullable = false, length = 50)
    private String memberPhone;

    OrderDeliveryAddressList orderDeliveryAddress;

    public static OrderRequestDto toDto(
            OrderRequestVo orderRequestVo,
            OrderDeliveryAddressList orderDeliveryAddress,
            String serialNum,
            LocalDateTime orderDate) {
        return OrderRequestDto.builder()
                .memberUUID(orderRequestVo.getMemberUUID())
                .deliveryPrice(orderRequestVo.getDeliveryPrice())
                .totalPrice(orderRequestVo.getTotalPrice())
                .cardInfo(orderRequestVo.getCardInfo())
                .memberName(orderRequestVo.getMemberName())
                .memberPhone(orderRequestVo.getMemberPhone())
                .orderDeliveryAddress(orderDeliveryAddress)
                .serialNumber(serialNum)
                .orderDate(orderDate)
                .build();
    }

    public Order toEntity() {
        return Order.builder()
                .memberUUID(memberUUID)
                .serialNumber(serialNumber)
                .orderDate(orderDate)
                .deliveryPrice(deliveryPrice)
                .totalPrice(totalPrice)
                .cardInfo(cardInfo)
                .memberName(memberName)
                .memberPhone(memberPhone)
                .build();
    }
}
