package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
