package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.vo.ProductResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProductResponseDto {

    private String productName;
    private LocalDate date;
    private String productUUID;
    private Integer productScore;

    public ProductResponseVo toResponseVo() {
        return ProductResponseVo.builder()
                .productName(productName)
                .date(date)
                .productUUID(productUUID)
                .productScore(productScore)
                .build();
    }

    @Builder
    public ProductResponseDto(String productName, LocalDate date, String productUUID, Integer productScore) {
        this.productName = productName;
        this.date = date;
        this.productUUID = productUUID;
        this.productScore = productScore;
    }
}
