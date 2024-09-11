package TRaMis8khae.starbucks.product.dto;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.ProductMedia;
import TRaMis8khae.starbucks.product.entity.ProductOption;
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
    private String productUUID;
    private Double price;
    private Long optionId;
    private Boolean soldOutChecked;
    private Boolean closedChecked;
    private Boolean openChecked;
    private Boolean thumbChecked;
    private String path;

    public static ProductResponseDto toDto(Product product, ProductOption productOption, ProductMedia productMedia) {
        return ProductResponseDto.builder()
            .productName(product.getProductName())
            .productUUID(product.getProductUUID())
            .price(product.getPrice())
            .optionId(productOption.getId())
            .soldOutChecked(productOption.getSoldOutChecked())
            .closedChecked(productOption.getClosedChecked())
            .thumbChecked(productMedia.getThumbChecked())
            .path(productMedia.getPath())
            .build();
    }

    public ProductResponseVo toVo() {
        return ProductResponseVo.builder()
            .productName(productName)
            .productUUID(productUUID)
            .price(price)
            .optionId(optionId)
            .soldOutChecked(soldOutChecked)
            .closedChecked(closedChecked)
            .thumbChecked(thumbChecked)
            .path(path)
            .build();
    }

}