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
    private LocalDate date;
    private String productUUID;
    private Integer productScore;

    public static ProductResponseDto toDto(Product product) {
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .productScore(product.getProductScore())
                .date(product.getDate())
                .productUUID(product.getProductUUID())
                .build();
    }

    public ProductResponseVo toVo() {
        return ProductResponseVo.builder()
                .productName(productName)
                .date(date)
                .productUUID(productUUID)
                .productScore(productScore)
                .build();
    }

}