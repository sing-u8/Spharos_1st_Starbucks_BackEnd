package TRaMis8khae.starbucks.product.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailInfoResponseVo {
    private Long productOptionId;
    private String productUUID;
    private String productName;
    private Double productPrice;
    private String imageType;
}
