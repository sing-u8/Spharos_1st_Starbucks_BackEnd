package TRaMis8khae.starbucks.product.dto.out;


import TRaMis8khae.starbucks.product.entity.ProductAdditionalProductList;
import TRaMis8khae.starbucks.product.vo.out.ProductAdditionalProductListResponseVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductAdditionalProductListResponseDto {

	private String productUUID;

	private String additionalUUID;

	public static ProductAdditionalProductListResponseDto toDto(ProductAdditionalProductList productAdditionalProductList) {

		return ProductAdditionalProductListResponseDto.builder()
			.productUUID(productAdditionalProductList.getProductUUID())
			.additionalUUID(productAdditionalProductList.getAdditionalUUID())
			.build();
	}

	public ProductAdditionalProductListResponseVo toVo() {

		return ProductAdditionalProductListResponseVo.builder()
			.productUUID(productUUID)
			.additionalUUID(additionalUUID)
			.build();
	}

}