package TRaMis8khae.starbucks.order.application;

import TRaMis8khae.starbucks.order.dto.OrderRequestDto;
import TRaMis8khae.starbucks.order.entity.Order;
import TRaMis8khae.starbucks.order.entity.OrderDeliveryAddressList;
import TRaMis8khae.starbucks.order.infrastructure.OrderRepository;
import TRaMis8khae.starbucks.order.vo.OrderRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void addOrder(OrderRequestVo orderRequestVo) {
        OrderDeliveryAddressList orderDeliveryAddress = new OrderDeliveryAddressList();
        String serialNum = UUID.randomUUID().toString();
        LocalDateTime orderDate = LocalDateTime.now();

        OrderRequestDto orderRequestDto = OrderRequestDto.toDto(
                orderRequestVo,
                orderDeliveryAddress,
                serialNum,
                orderDate);

        Order order = orderRequestDto.toEntity();

        orderRepository.save(order);

        // todo 주문배송리스트, 상품주문리스트 추가 필요
        OrderDeliveryAddressList orderDeliveryAddressList = new OrderDeliveryAddressList();


    }
}
