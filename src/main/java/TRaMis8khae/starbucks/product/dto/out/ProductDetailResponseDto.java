package TRaMis8khae.starbucks.product.dto.out;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.out.ProductDetailResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class ProductDetailResponseDto {

	private String productName;

	private String description;

	private Double price;

	private Boolean isAdditionalTogether;

	private Boolean additionalChecked;

	private Integer maxOrderCount;

	private List<Long> thumbIds;

	private List<Long> detailIds;


	public static ProductDetailResponseDto toDto(Product product, List<Long> thumbId, List<Long> detailIds) {

		return ProductDetailResponseDto.builder()
			.price(product.getPrice())
			.productName(product.getProductName())
			.description(product.getDescription())
			.isAdditionalTogether(product.getIsAdditionalTogether())
			.additionalChecked(product.getAdditionalChecked())
			.maxOrderCount(product.getMaxOrderCount())
			.thumbIds(thumbId)
			.detailIds(detailIds)
			.build();
	}


	public ProductDetailResponseVo toVo() {

		return ProductDetailResponseVo.builder()
			.price(price)
			.productName(productName)
			.description(description)
			.isAdditionalTogether(isAdditionalTogether)
			.additionalChecked(additionalChecked)
			.maxOrderCount(maxOrderCount)
			.thumbIds(thumbIds)
			.detailIds(detailIds)
			.build();
	}
}
