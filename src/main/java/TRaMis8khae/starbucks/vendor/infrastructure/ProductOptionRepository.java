package TRaMis8khae.starbucks.vendor.infrastructure;


import TRaMis8khae.starbucks.vendor.entity.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
	Optional<ProductOption> findByProductUUID(String productUUID);

	List<ProductOption> findByClosedChecked(Boolean closedChecked);

}
