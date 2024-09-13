package TRaMis8khae.starbucks.voucher.infrastructure;

import TRaMis8khae.starbucks.voucher.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    Optional<Voucher> findByVoucherCode(String voucherCode);

}