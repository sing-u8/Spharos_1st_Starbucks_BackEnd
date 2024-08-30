package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductUuid(UUID productUuid);
}
