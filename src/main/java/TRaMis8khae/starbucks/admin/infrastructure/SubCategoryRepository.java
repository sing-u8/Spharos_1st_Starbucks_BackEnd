package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    Optional<SubCategory> findByName(String name);
    Optional<SubCategory> findByCode(String code);

    List<SubCategory> findByMainCategoryCode(String MainCategoryCode);

//    Boolean existsByName(String name);
//    Boolean existsByCode(String code);

}