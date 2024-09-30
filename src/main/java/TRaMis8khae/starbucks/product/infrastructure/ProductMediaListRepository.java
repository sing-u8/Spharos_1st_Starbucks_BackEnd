package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.entity.ProductMediaList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductMediaListRepository extends JpaRepository<ProductMediaList, Long> {

	List<ProductMediaList> findByProductUUID(String productUUID);
}
