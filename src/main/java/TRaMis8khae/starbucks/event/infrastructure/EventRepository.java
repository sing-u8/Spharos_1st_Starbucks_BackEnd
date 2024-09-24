package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
