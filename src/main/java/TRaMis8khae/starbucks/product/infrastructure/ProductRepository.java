package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductUUID(String productUUID);
    boolean existsByproductName(String productName);
    boolean existsByProductUUID(String productUUID);
    boolean existsByEngravingChecked(Boolean engravingChecked);

}