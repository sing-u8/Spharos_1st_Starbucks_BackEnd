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
    private LocalDate date;
    private String productUUID;
    //private Integer productScore;

    public static ProductRequestDto toDto(ProductRequestVo productRequestVo) {
        return ProductRequestDto.builder()
                .productName(productRequestVo.getProductName())
                .date(productRequestVo.getDate())
                .build();
    }

    public Product toEntity(String productUUID) {
        return Product.builder()
                .productUUID(productUUID)
                .date(date)
                .productName(productName)
                //.productScore(productScore)
                .build();
    }

}