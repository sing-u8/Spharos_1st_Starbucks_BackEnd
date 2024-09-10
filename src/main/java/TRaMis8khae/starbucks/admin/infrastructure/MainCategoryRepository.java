package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {

    Optional<MainCategory> findByName(String name);
    Optional<MainCategory> findByCode(String Code);

//    Boolean existsByName(String name);
//    Boolean existByCode(String code);

}