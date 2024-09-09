package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {

    Optional<MainCategory> findByName(String name);
    Optional<MainCategory> findByCode(String Code);

//    Boolean existsByName(String name);
//    Boolean existByCode(String code);

}