package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.domain.Product;
import TRaMis8khae.starbucks.product.domain.ProductInfoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    Optional<Product> findByProductUuid(String productUuid);
    List<ProductInfoList> findByProductInfoUuid(String productUuid);
}
