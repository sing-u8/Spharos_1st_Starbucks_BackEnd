package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.auth.entity.TermsConsentList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermConsentListRepository extends JpaRepository<TermsConsentList, Long> {

}
