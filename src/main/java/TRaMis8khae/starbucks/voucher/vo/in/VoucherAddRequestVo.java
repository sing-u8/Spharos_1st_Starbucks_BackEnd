package TRaMis8khae.starbucks.voucher.vo.in;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VoucherAddRequestVo {

    private String name;

    private Double price;

    private String productUUID;

    private LocalDateTime expireDate;

}