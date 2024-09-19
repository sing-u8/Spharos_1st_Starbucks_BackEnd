package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.event.entity.ProductEventList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductEventListRepository extends JpaRepository<ProductEventList, Long> {

//    Optional<ProductEventList> findByEventId(Long eventId);
Optional<ProductEventList> findByEventId(Long id);

}
