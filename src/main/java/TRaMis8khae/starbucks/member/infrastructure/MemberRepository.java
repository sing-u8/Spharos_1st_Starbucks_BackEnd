package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
