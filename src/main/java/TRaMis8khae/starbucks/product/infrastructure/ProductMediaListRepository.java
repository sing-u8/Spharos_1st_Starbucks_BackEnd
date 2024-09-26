package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.ProductMediaList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductMediaListRepository extends JpaRepository<ProductMediaList, Long> {

	List<ProductMediaList> findByProductUUID(String productUUID);
}
