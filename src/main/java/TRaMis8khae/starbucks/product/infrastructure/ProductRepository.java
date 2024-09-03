package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
