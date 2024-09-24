package TRaMis8khae.starbucks.vendor.dto.out;

import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.vo.out.ProductCategoryListResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryListResponseDto {

    private String productUUID;

    public static ProductCategoryListResponseDto toDto(ProductCategoryList productCategoryList) {
        return ProductCategoryListResponseDto.builder()
                .productUUID(productCategoryList.getProductUUID())
                .build();
    }

    public ProductCategoryListResponseVo toVo() {
        return ProductCategoryListResponseVo.builder()
                .productUUID(productUUID)
                .build();
    }

}