package TRaMis8khae.starbucks.voucher.application;

import TRaMis8khae.starbucks.voucher.dto.in.VoucherAddRequestDto;
import TRaMis8khae.starbucks.voucher.dto.in.VoucherRegistRequestDto;
import TRaMis8khae.starbucks.voucher.dto.out.VoucherReadResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface VoucherService {

    void addVoucher(List<VoucherAddRequestDto> dtos);

    void registVoucher(VoucherRegistRequestDto dto);

    void deleteVoucher(Long id);

    Slice<VoucherReadResponseDto> findVouchers(Pageable pageable, String memberUUID);
}