package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ColorRepository extends JpaRepository<Color, Long> {

	Optional<Color> findByName(String name);

	Boolean existsByName(String name);
}
