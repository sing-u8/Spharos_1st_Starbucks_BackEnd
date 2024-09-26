package TRaMis8khae.starbucks.product.dto.in;


import TRaMis8khae.starbucks.product.entity.ProductMediaList;
import TRaMis8khae.starbucks.product.vo.in.ProductMediaListRequestVo;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ProductMediaListRequestDto {

	private String productUUID;

	private Long mediaId;


	public static ProductMediaListRequestDto toDto(ProductMediaListRequestVo requestVo) {

		return ProductMediaListRequestDto.builder()
			.productUUID(requestVo.getProductUUID())
			.mediaId(requestVo.getMediaId())
			.build();
	}

	public ProductMediaList toEntity() {
		return ProductMediaList.builder()
			.productUUID(productUUID)
			.mediaId(mediaId)
			.build();
	}

}
