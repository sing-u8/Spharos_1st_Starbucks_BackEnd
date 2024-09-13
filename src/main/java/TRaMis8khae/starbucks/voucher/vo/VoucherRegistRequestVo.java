package TRaMis8khae.starbucks.voucher.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VoucherRegistRequestVo {

    private String memberUUID;

    private String voucherCode;

}