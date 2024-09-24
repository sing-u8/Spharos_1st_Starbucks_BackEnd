package TRaMis8khae.starbucks.voucher.infrastructure;

import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.infrastructure.dynamic.MemberVoucherListRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberVoucherListRepository extends JpaRepository<MemberVoucherList, Long>, MemberVoucherListRepositoryCustom {

}