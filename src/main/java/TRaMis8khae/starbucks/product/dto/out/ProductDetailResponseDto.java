package TRaMis8khae.starbucks.product.dto.out;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.out.ProductDetailResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDetailResponseDto {

	private String productName;

	private String description;

	private Double price;

	private Double productScore;

	private Boolean isAdditionalTogether;

	private Boolean additionalChecked;

	private Integer maxOrderCount;


	public static ProductDetailResponseDto toDto(Product product) {

		return ProductDetailResponseDto.builder()
			.price(product.getPrice())
			.productName(product.getProductName())
			.description(product.getDescription())
			.productScore(product.getProductScore())
			.isAdditionalTogether(product.getIsAdditionalTogether())
			.additionalChecked(product.getAdditionalChecked())
			.maxOrderCount(product.getMaxOrderCount())
			.build();
	}


	public ProductDetailResponseVo toVo() {

		return ProductDetailResponseVo.builder()
			.price(price)
			.productName(productName)
			.description(description)
			.productScore(productScore)
			.isAdditionalTogether(isAdditionalTogether)
			.additionalChecked(additionalChecked)
			.maxOrderCount(maxOrderCount)
			.build();
	}
}
