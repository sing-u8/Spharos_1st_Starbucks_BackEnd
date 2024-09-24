package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.event.entity.EventMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventMediaRepository extends JpaRepository<EventMedia, Long> {

    List<EventMedia> findByEventId(Long eventId);
}
