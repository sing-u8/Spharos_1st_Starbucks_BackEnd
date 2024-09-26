package TRaMis8khae.starbucks.admin.infrastructure;


import TRaMis8khae.starbucks.admin.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
