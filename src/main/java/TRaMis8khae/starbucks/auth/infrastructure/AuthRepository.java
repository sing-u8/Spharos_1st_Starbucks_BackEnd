package TRaMis8khae.starbucks.auth.infrastructure;

import TRaMis8khae.starbucks.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
