package TRaMis8khae.starbucks.voucher.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VoucherAddResponseVo {

    @Column(length = 50)
    private String name;

    private Double price;

    private String productUUID;

    private LocalDateTime expireDate;

    private String voucherCode;

}