package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory, Integer> {

    Optional<MiddleCategory> findByName(String name);
    Optional<MiddleCategory> findByCode(String code);

    List<MiddleCategory> findByTopCategoryCode(String code);
	Boolean existsByName(String name);

	//    Boolean existsByName(String name);
//    Boolean existsByCode(String code);

}