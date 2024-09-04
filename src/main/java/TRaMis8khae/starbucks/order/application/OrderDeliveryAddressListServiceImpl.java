package TRaMis8khae.starbucks.order.application;

import TRaMis8khae.starbucks.order.infrastructure.OrderDeliveryAddressListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDeliveryAddressListServiceImpl implements OrderDeliveryAddressListService {

    private final OrderDeliveryAddressListRepository orderDeliveryAddressListRepository;


    @Override
    public void createOrderDeliveryAddressList() {

    }
}
