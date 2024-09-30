package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.event.entity.EventMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventMediaRepository extends JpaRepository<EventMedia, Long> {

    List<EventMedia> findAllByEventId(Long eventId);

    List<EventMedia> findByProductId(Long productId);

    EventMedia findByMediaId(Long mediaId);

}
