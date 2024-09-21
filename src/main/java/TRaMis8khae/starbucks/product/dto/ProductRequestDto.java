package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.ProductRequestVo;
import lombok.*;


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
    private Integer minOrderCount;
    private Long mediaId;
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
            .minOrderCount(productRequestVo.getMinOrderCount())
            .mediaId(productRequestVo.getMediaId())
            .build();
    }

    public Product toEntity(String productUUID) {
        return Product.builder()
            .productUUID(productUUID)
            .productName(productName)
            .price(price)
            .description(description)
            .additionalChecked(additionalChecked)
            .isAdditionalTogether(isAdditionalTogether)
            .engravingChecked(engravingChecked)
            .maxOrderCount(maxOrderCount)
            .minOrderCount(minOrderCount)
            .mediaId(mediaId)
            .build();
    }

}