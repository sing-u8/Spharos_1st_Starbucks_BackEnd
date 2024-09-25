package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.auth.entity.Marketing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketingRepository extends JpaRepository<Marketing, Long> {
}

