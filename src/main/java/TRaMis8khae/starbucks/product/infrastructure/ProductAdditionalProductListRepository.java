package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.ProductAdditionalProductList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductAdditionalProductListRepository extends JpaRepository<ProductAdditionalProductList, Long> {

	List<ProductAdditionalProductList> findAllByProductUUID(String uuid);

}
