package TRaMis8khae.starbucks.voucher.infrastructure.dynamic;

import TRaMis8khae.starbucks.voucher.dto.out.VoucherReadResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface MemberVoucherListRepositoryCustom {

    Slice<VoucherReadResponseDto> findVouchers(Pageable pageable, String memberUUID);

}