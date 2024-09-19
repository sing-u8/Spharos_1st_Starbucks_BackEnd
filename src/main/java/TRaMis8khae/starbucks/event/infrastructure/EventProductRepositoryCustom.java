package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.product.entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface EventProductRepositoryCustom {

//    List<Product> getEventProductList(String productUUID);

    Slice<Product> findByProductUUID(String productUUID, PageRequest pageRequest);

}
