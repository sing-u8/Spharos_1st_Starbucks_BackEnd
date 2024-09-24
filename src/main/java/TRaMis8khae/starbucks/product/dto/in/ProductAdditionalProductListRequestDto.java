package TRaMis8khae.starbucks.product.dto.in;


import TRaMis8khae.starbucks.product.entity.ProductAdditionalProductList;
import TRaMis8khae.starbucks.product.vo.in.ProductAdditionalProductListRequestVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductAdditionalProductListRequestDto {

	private String productUUID;

	private String additionalUUID;

	public static ProductAdditionalProductListRequestDto toDto(ProductAdditionalProductListRequestVo requestVo) {

		return ProductAdditionalProductListRequestDto.builder()
			.productUUID(requestVo.getProductUUID())
			.additionalUUID(requestVo.getAdditionalUUID())
			.build();
	}

	public ProductAdditionalProductList toEntity() {

		return ProductAdditionalProductList.builder()
			.productUUID(productUUID)
			.additionalUUID(additionalUUID)
			.build();
	}

}
