package TRaMis8khae.starbucks.voucher.application;

import TRaMis8khae.starbucks.voucher.dto.*;

import java.util.List;

public interface VoucherService {

    List<VoucherAddResponseDto> addVoucher(List<VoucherAddRequestDto> dtos);

    void registVoucher(VoucherRegistRequestDto dto);

    void deleteVoucher(Long id);

    List<VoucherReadResponseDto> findVouchers(String memberUUID);
}