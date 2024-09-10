package TRaMis8khae.starbucks.voucher.application;

import TRaMis8khae.starbucks.voucher.vo.VoucherAddRequestVo;
import TRaMis8khae.starbucks.voucher.vo.VoucherAddResponseVo;

import java.util.List;

public interface VoucherService {

    VoucherAddResponseVo addVoucher(VoucherAddRequestVo vo);
}