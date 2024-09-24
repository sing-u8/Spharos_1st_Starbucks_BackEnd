package TRaMis8khae.starbucks.voucher.vo.out;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VoucherReadResponseVo {

    private String memberUUID;

    private LocalDateTime registDate;

    private String name;

    private Double price;

    private String productUUID;

    private LocalDateTime expireDate;

    private String voucherCode;

}