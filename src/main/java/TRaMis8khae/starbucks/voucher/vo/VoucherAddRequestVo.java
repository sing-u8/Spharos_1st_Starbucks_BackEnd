package TRaMis8khae.starbucks.voucher.vo;

import TRaMis8khae.starbucks.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class VoucherAddRequestVo {

    private String name;

    private Double price;

    private String productUUID;

}