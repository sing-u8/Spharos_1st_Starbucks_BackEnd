package TRaMis8khae.starbucks.product.dto.out;


import TRaMis8khae.starbucks.product.entity.ProductMediaList;
import TRaMis8khae.starbucks.product.vo.out.ProductMediaListResponseVo;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ProductMediaListResponseDto {

	private String productUUID;

	private Long mediaId;


	public static ProductMediaListResponseDto toDto(ProductMediaList productMediaList) {

		return ProductMediaListResponseDto.builder()
			.productUUID(productMediaList.getProductUUID())
			.mediaId(productMediaList.getMediaId())
			.build();
	}


	public ProductMediaListResponseVo toVo() {

		return ProductMediaListResponseVo.builder()
			.mediaId(mediaId)
			.productUUID(productUUID)
			.build();
	}

}
