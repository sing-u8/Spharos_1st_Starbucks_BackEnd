package TRaMis8khae.starbucks.voucher.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.voucher.application.VoucherService;
import TRaMis8khae.starbucks.voucher.vo.VoucherAddRequestVo;
import TRaMis8khae.starbucks.voucher.vo.VoucherAddResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voucher")
public class VoucherController {

    private final VoucherService voucherService;

    @PostMapping("/add")
    public CommonResponseEntity<List<VoucherAddResponseVo>> addVoucher(@RequestBody VoucherAddRequestVo vo) {

        List<VoucherAddResponseVo> responseVo = voucherService.addVoucher(vo);

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "상품권 추가 성공",
                responseVo
        );
    }

}