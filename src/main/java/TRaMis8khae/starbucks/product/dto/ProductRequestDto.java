package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProductRequestDto {
    private String productName;
    private LocalDate date;
    private String productUUID;
    private Integer productScore;

    public Product toEntity(String productUUID) {
        return Product.builder()
                .productUUID(productUUID)
                .date(date)
                .productName(productName)
                .productScore(productScore)
                .build();
    }
    @Builder
    public ProductRequestDto(String productName, LocalDate date, String productUUID, Integer productScore) {
        this.productName = productName;
        this.date = date;
        this.productUUID = productUUID;
        this.productScore = productScore;
    }
}
