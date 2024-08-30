package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.vo.ProductResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ProductResponseDto {

    private String productName;
    private LocalDate date;
    private UUID productUuid;
    private Integer productScore;

    public ProductResponseVo toResponseVo() {
        return ProductResponseVo.builder()
                .productName(productName)
                .date(date)
                .productUuid(productUuid)
                .productScore(productScore)
                .build();
    }

    @Builder
    public ProductResponseDto(String productName, LocalDate date, UUID productUuid, Integer productScore) {
        this.productName = productName;
        this.date = date;
        this.productUuid = productUuid;
        this.productScore = productScore;
    }
}
