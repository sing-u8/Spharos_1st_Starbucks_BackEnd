package TRaMis8khae.starbucks.voucher.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VoucherAddRequestDto {

    private String name;

    private Double price;

    private String productUUID;

}