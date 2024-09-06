package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    Optional<SubCategory> findBySubCategoryName(String CategoryName);
    List<SubCategory> findByMainCategoryMainCategoryName(String CategoryName);
    List<SubCategory> findByMainCategoryId(Integer CategoryId);
    boolean existsBySubCategoryName(String categoryName);
}
