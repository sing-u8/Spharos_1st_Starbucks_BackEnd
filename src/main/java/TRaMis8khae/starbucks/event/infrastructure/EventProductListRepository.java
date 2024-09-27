package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.event.entity.ProductEventList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventProductListRepository extends JpaRepository<ProductEventList, Long> {

    List<ProductEventList> findAllByEventId(Long id);

}
