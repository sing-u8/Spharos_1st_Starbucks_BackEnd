package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductUUID(String productUUID);
    boolean existsByproductName(String productName);
}
