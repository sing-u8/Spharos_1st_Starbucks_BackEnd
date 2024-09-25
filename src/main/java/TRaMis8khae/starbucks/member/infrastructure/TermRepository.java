package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.auth.entity.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository extends JpaRepository<Terms, Long> {
}
