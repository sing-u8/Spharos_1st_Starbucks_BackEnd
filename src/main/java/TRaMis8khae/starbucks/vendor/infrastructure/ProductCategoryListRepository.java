package TRaMis8khae.starbucks.vendor.infrastructure;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryListRepository extends JpaRepository<ProductCategoryList, Long> {
}
