package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    Optional<MainCategory> findByCategoryName(String CategoryName);
    boolean existsByCategoryName(String categoryName);
}
