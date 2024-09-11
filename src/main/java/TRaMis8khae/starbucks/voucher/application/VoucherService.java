package TRaMis8khae.starbucks.voucher.application;

import TRaMis8khae.starbucks.voucher.dto.*;
import TRaMis8khae.starbucks.voucher.vo.VoucherReadRequestVo;
import TRaMis8khae.starbucks.voucher.vo.VoucherReadResponseVo;

import java.util.List;

public interface VoucherService {

    List<VoucherAddResponseDto> addVoucher(List<VoucherAddRequestDto> dtos);

    Void registVoucher(VoucherRegistRequestDto dto);

    void deleteVoucher(Long id);

    List<VoucherReadResponseDto> findVouchers(VoucherReadRequestDto dto);
}