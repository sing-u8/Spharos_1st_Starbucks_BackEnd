package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.dto.OrderRequestDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.entity.PurchaseDelivery;
import TRaMis8khae.starbucks.purchase.infrastructure.OrderDeliveryAddressRepository;
import TRaMis8khae.starbucks.purchase.infrastructure.OrderRepository;
import TRaMis8khae.starbucks.purchase.vo.OrderRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDeliveryAddressRepository orderDeliveryAddressRepository;

    @Override
    public void addOrder(OrderRequestVo orderRequestVo) {
        // todo 주문배송 리포지토리에서 꺼내야 함
        PurchaseDelivery purchaseDelivery = new PurchaseDelivery();
        String serialNum = UUID.randomUUID().toString();
        LocalDateTime orderDate = LocalDateTime.now();

        OrderRequestDto orderRequestDto = OrderRequestDto.toDto(
                orderRequestVo,
                purchaseDelivery,
                serialNum,
                orderDate);

        Purchase purchase = orderRequestDto.toEntity();

        log.info("order: {}", purchase);

        orderRepository.save(purchase);

        // todo 주문배송리스트, 상품주문리스트 추가 필요


    }
}
