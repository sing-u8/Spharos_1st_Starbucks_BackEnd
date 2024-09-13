package TRaMis8khae.starbucks.product.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDetailResponseVo {

    private Long productOptionId;
    private String productUUID;
    private String productName;
    private Double productPrice;
    private String imageType;

}