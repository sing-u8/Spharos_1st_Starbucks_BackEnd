package TRaMis8khae.starbucks.vendor.dto;

import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.vo.ProductCategoryListResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryListResponseDto {

    private Long productId;

    public static ProductCategoryListResponseDto toDto(ProductCategoryList productCategoryList) {
        return ProductCategoryListResponseDto.builder()
                .productId(productCategoryList.getProduct().getId())
                .build();
    }

    public ProductCategoryListResponseVo toVo() {
        return ProductCategoryListResponseVo.builder()
                .productId(productId)
                .build();
    }

}