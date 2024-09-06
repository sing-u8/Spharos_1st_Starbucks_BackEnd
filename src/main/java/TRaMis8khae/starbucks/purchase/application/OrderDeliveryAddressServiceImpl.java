package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.entity.PurchaseDelivery;
import TRaMis8khae.starbucks.purchase.infrastructure.OrderDeliveryAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDeliveryAddressServiceImpl implements OrderDeliveryAddressService {

    private final OrderDeliveryAddressRepository orderDeliveryAddressRepository;


    @Override
    public void addOrderDeliveryAddress() {
        PurchaseDelivery purchaseDelivery = new PurchaseDelivery();
        orderDeliveryAddressRepository.save(purchaseDelivery);
    }
}
