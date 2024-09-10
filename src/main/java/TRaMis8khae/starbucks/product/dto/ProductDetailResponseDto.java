package TRaMis8khae.starbucks.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponseDto {

    private Long productOptionId;
    private String productUUID;
    private String productName;
    private Double productPrice;
    private String imageType;

}