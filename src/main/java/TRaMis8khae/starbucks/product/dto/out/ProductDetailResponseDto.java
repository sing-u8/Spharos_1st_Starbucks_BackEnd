package TRaMis8khae.starbucks.product.dto.out;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.out.ProductDetailResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDetailResponseDto {

	private String description;

	private Double productScore;

	private Boolean isAdditionalTogether;

	private Integer maxOrderCount;


	public static ProductDetailResponseDto toDto(Product product) {

		return ProductDetailResponseDto.builder()
			.description(product.getDescription())
			.productScore(product.getProductScore())
			.isAdditionalTogether(product.getIsAdditionalTogether())
			.maxOrderCount(product.getMaxOrderCount())
			.build();
	}


	public ProductDetailResponseVo toVo() {

		return ProductDetailResponseVo.builder()
			.description(description)
			.productScore(productScore)
			.isAdditionalTogether(isAdditionalTogether)
			.maxOrderCount(maxOrderCount)
			.build();
	}
}
