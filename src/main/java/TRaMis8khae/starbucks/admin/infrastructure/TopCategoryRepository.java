package TRaMis8khae.starbucks.admin.infrastructure;

import TRaMis8khae.starbucks.admin.entity.TopCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopCategoryRepository extends JpaRepository<TopCategory, Integer> {

    Optional<TopCategory> findByName(String name);
    Optional<TopCategory> findByCode(String Code);

    Boolean existsByName(String name);
    Boolean existsBySequence(Integer sequence);

}