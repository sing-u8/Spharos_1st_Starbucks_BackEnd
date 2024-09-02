package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ProductRequestDto {
    private String productName;
    private LocalDate date;
    private String productUuid;
    private Integer productScore;

    public Product toEntity(String productUuid) {
        return Product.builder()
                .productUuid(productUuid)
                .date(date)
                .productName(productName)
                .productScore(productScore)
                .build();
    }
    @Builder
    public ProductRequestDto(String productName, LocalDate date, String productUuid, Integer productScore) {
        this.productName = productName;
        this.date = date;
        this.productUuid = productUuid;
        this.productScore = productScore;
    }
}
