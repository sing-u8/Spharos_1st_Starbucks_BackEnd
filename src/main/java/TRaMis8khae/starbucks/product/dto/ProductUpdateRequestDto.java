package TRaMis8khae.starbucks.product.dto;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.ProductUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductUpdateRequestDto {

	private String productName;

	private Double price;

	private Boolean additionalChecked;

	private Boolean isAdditionalTogether;

	private Integer maxOrderCount;

	private Boolean engravingChecked;

	public static ProductUpdateRequestDto toDto(ProductUpdateRequestVo productUpdateRequestVo) {

		return ProductUpdateRequestDto.builder()
			.productName(productUpdateRequestVo.getProductName())
			.price(productUpdateRequestVo.getPrice())
			.additionalChecked(productUpdateRequestVo.getAdditionalChecked())
			.isAdditionalTogether(productUpdateRequestVo.getIsAdditionalTogether())
			.maxOrderCount(productUpdateRequestVo.getMaxOrderCount())
			.engravingChecked(productUpdateRequestVo.getEngravingChecked())
			.build();
	}


	public Product toEntity(Product product) {

		return Product.builder()
			.id(product.getId())
			.productName(productName)
			.productUUID(product.getProductUUID())
			.productScore(product.getProductScore())
			.price(price)
			.description(product.getDescription())
			.additionalChecked(additionalChecked)
			.isAdditionalTogether(isAdditionalTogether)
			.maxOrderCount(maxOrderCount)
			.engravingChecked(engravingChecked)
			.mediaIds(product.getMediaIds())
			.build();
	}
}
