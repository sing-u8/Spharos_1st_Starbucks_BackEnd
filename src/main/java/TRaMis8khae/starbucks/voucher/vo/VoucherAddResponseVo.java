package TRaMis8khae.starbucks.voucher.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VoucherAddResponseVo {

    private String voucherCode;

    private String productUUID;

}