package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.ProductResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private String productName;
    private String productUUID;
    private Long optionId;
    private Double price;
    private Boolean thumbChecked;

    public ProductResponseVo toVo() {
        return ProductResponseVo.builder()
                .productName(productName)
                .productUUID(productUUID)
                .optionId(optionId)
                .price(price)
                .thumbChecked(thumbChecked)
                .build();
    }

}