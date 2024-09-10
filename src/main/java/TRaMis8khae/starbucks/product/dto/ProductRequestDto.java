package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.ProductRequestVo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String productName;
    private Double price;
    private String description;
    private Boolean additionalChecked;
    private String productUUID;

    public static ProductRequestDto toDto(ProductRequestVo productRequestVo) {
        return ProductRequestDto.builder()
            .productName(productRequestVo.getProductName())
            .price(productRequestVo.getPrice())
            .description(productRequestVo.getDescription())
            .additionalChecked(productRequestVo.getAdditionalChecked())
            .build();
    }

    public Product toEntity(String productUUID) {
        return Product.builder()
            .productUUID(productUUID)
            .productName(productName)
            .price(price)
            .description(description)
            .additionalChecked(additionalChecked)
            .build();
    }

}