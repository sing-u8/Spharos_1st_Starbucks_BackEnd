package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepositoryCustom {

	List<Product> getProductListWithPrice(Double minPrice, Double maxPrice);

}
