package TRaMis8khae.starbucks.product.dto.in;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.in.ProductRequestVo;
import lombok.*;

import java.util.List;


@Getter
@Builder
public class ProductRequestDto {

    private String productName;
    private Double price;
    private String description;
    private Boolean additionalChecked;
    private Boolean isAdditionalTogether;
    private String productUUID;
    private Boolean engravingChecked;
    private Integer maxOrderCount;
//    private String volumeName;

    public static ProductRequestDto toDto(ProductRequestVo productRequestVo) {
        return ProductRequestDto.builder()
            .productName(productRequestVo.getProductName())
            .price(productRequestVo.getPrice())
            .description(productRequestVo.getDescription())
            .additionalChecked(productRequestVo.getAdditionalChecked())
            .isAdditionalTogether(productRequestVo.getIsAdditionalTogether())
            .engravingChecked(productRequestVo.getEngravingChecked())
            .maxOrderCount(productRequestVo.getMaxOrderCount())
            .build();
    }

    public Product toEntity(String productUUID) {
        return Product.builder()
            .productUUID(productUUID)
            .productName(productName)
            .productScore(0.0)
            .price(price)
            .description(description)
            .additionalChecked(additionalChecked)
            .isAdditionalTogether(isAdditionalTogether)
            .engravingChecked(engravingChecked)
            .maxOrderCount(maxOrderCount)
            .minOrderCount(1)
            .build();
    }

}