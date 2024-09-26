package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.ProductMediaList;
import io.jsonwebtoken.security.Jwks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductMediaListRepository extends JpaRepository<ProductMediaList, Long> {

    Optional<ProductMediaList> findByProductUUID(String productUUID);

}
