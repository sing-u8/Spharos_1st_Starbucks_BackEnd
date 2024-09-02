package TRaMis8khae.starbucks.auth.infrastructure;

import TRaMis8khae.starbucks.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginId(String loginId);
    Optional<Member> findByMemberUuid(UUID memberUuid);
//    void findByUuid(UUID memberUuid);
}
