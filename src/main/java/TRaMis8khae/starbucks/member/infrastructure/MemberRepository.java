package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberUUID(String memberUUID);

}