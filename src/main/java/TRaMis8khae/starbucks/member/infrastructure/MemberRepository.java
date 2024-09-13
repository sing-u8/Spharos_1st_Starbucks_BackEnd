package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.entity.Member;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberUUID(String memberUUID);

}