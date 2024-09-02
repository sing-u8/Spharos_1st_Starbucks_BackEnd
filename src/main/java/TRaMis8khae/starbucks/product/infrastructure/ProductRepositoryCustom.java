package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.domain.ProductInfo;
import TRaMis8khae.starbucks.product.domain.ProductInfoList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepositoryCustom {
    List<ProductInfoList> getProductInfoWithProduct(String productUuid);
}
