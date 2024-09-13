package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    List<SubCategory> findByMainCategoryId(Integer CategoryId);
    List<SubCategory> findByMainCategoryMainCategoryName(String CategoryName);

    Optional<SubCategory> findBySubCategoryName(String CategoryName);

    boolean existsBySubCategoryName(String categoryName);

}