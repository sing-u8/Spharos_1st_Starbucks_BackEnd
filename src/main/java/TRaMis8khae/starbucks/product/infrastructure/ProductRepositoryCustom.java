package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.entity.ProductInfoList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryCustom {
    List<ProductInfoList> getProductInfoWithProduct(String productUUID);
}
