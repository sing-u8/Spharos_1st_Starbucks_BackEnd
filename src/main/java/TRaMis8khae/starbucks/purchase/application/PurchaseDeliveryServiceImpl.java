package TRaMis8khae.starbucks.purchase.application;

import TRaMis8khae.starbucks.purchase.entity.PurchaseDelivery;
import TRaMis8khae.starbucks.purchase.infrastructure.PurchaseDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseDeliveryServiceImpl implements PurchaseDeliveryService {

    private final PurchaseDeliveryRepository purchaseDeliveryRepository;

    @Override
    public void addPurchaseDelivery() {
        PurchaseDelivery purchaseDelivery = new PurchaseDelivery();
        purchaseDeliveryRepository.save(purchaseDelivery);
    }

}