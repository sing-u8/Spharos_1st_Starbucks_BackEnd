package TRaMis8khae.starbucks.admin.infrastructure;


import TRaMis8khae.starbucks.admin.entity.BottomCategory;
import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BottomCategoryRepository extends JpaRepository<BottomCategory, Long> {

	Optional<BottomCategory> findByName(String name);
	Optional<BottomCategory> findByCode(String code);

	List<BottomCategory> findByMiddleCategoryCode(String middleCategoryCode);
}
