package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
	Optional<ProductOption> findByProductUUID(String productUUID);
}
