package TRaMis8khae.starbucks.voucher.application;

import TRaMis8khae.starbucks.voucher.infrastructure.VoucherRepository;
import TRaMis8khae.starbucks.voucher.vo.VoucherAddRequestVo;
import TRaMis8khae.starbucks.voucher.vo.VoucherAddResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    // 상품권 추가 (관리자)
    @Override
    public VoucherAddResponseVo addVoucher(VoucherAddRequestVo vo) {

        List<VoucherAddResponseVo> responseVoList = new ArrayList<>();

        return null;
    }

}