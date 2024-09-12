package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.common.entity.Media;
import TRaMis8khae.starbucks.product.entity.ProductMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MediaRepository extends JpaRepository<ProductMedia, Long> {

	Optional<ProductMedia> findByProductUUID(String productUUID);

//	Optional<ProductMedia> findByThumbChecked(Boolean thumbChecked);
}
