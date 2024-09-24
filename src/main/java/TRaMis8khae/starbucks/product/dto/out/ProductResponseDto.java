package TRaMis8khae.starbucks.product.dto.out;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.out.ProductResponseVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductResponseDto {

    private String productName;
    private String productUUID;
    private Double price;

    public static ProductResponseDto toDto(Product product) {
        return ProductResponseDto.builder()
            .productName(product.getProductName())
            .productUUID(product.getProductUUID())
            .price(product.getPrice())
            .build();
    }

    public ProductResponseVo toVo() {
        return ProductResponseVo.builder()
            .productName(productName)
            .productUUID(productUUID)
            .price(price)
            .build();
    }

}