package TRaMis8khae.starbucks.voucher.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class VoucherReadResponseVo {
    private String memberUUID;

    private LocalDateTime registDate;

    private String name;

    private Double price;

    private String productUUID;

    private LocalDateTime expireDate;

    private String voucherCode;
}