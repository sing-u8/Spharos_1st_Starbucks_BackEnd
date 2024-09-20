package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {

	Boolean existsByName(String name);

	Optional<Volume> findByName(String name);
}
