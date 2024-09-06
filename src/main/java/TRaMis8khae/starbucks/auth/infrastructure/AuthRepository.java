package TRaMis8khae.starbucks.auth.infrastructure;

import TRaMis8khae.starbucks.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findByMemberUUID(String memberUUID);
    void deleteByMemberUUID(String memberUUID);
    //TEST!!!!

}
