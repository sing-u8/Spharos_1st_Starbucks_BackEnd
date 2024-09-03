package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberAddressListRepository extends JpaRepository<MemberAddressList, Long> {
    Optional<MemberAddressList> findByMemberUUID(String memberUUID);
}
