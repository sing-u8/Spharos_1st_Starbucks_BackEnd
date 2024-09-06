package TRaMis8khae.starbucks.purchase.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.purchase.application.OrderService;
import TRaMis8khae.starbucks.purchase.vo.OrderRequestVo;
import TRaMis8khae.starbucks.purchase.vo.OrderResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order") // 임시
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public CommonResponseEntity<OrderResponseVo> addOrder(OrderRequestVo orderRequestVo) {
        orderService.addOrder(orderRequestVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }
}
