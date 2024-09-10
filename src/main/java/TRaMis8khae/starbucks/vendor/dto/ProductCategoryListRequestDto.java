package TRaMis8khae.starbucks.vendor.dto;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.ProductRequestVo;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.vo.ProductCategoryListRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryListRequestDto {

    private String subCode;
    private String mainCode;
    private Long productId;

    public static ProductCategoryListRequestDto toDto(ProductCategoryListRequestVo productCategoryListRequestVo) {
        return ProductCategoryListRequestDto.builder()
            .mainCode(productCategoryListRequestVo.getMainCode())
            .subCode(productCategoryListRequestVo.getSubCode())
            .productId(productCategoryListRequestVo.getProductId())
            .build();
    }

    public ProductCategoryList toEntity(Product product) {
        return ProductCategoryList.builder()
            .mainCode(mainCode)
            .subCode(subCode)
            .product(product)
            .build();
    }

}