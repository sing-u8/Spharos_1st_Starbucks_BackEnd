package TRaMis8khae.starbucks.voucher.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VoucherAddResponseDto {

    private String voucherCode;

    private String voucherName;

}