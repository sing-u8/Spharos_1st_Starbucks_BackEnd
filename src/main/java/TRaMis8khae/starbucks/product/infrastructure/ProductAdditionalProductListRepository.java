package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.ProductAdditionalProductList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductAdditionalProductListRepository extends JpaRepository<ProductAdditionalProductList, Long> {

	List<ProductAdditionalProductList> findAllByProductUUID(String uuid);

}
