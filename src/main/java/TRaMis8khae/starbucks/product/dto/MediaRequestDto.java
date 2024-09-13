package TRaMis8khae.starbucks.product.dto;


import TRaMis8khae.starbucks.common.entity.Media;
import TRaMis8khae.starbucks.product.entity.ProductMedia;
import TRaMis8khae.starbucks.product.vo.MediaRequestVo;
import TRaMis8khae.starbucks.product.vo.MediaResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MediaRequestDto {

	private String path;

	private Boolean thumbChecked;

	private Boolean mainChecked;

	private Boolean detailChecked;

	private Boolean productChecked;

	private String productUUID;


	public static MediaRequestDto toDto(MediaRequestVo mediaRequestVo) {

		return MediaRequestDto.builder()
			.path(mediaRequestVo.getPath())
			.thumbChecked(mediaRequestVo.getThumbChecked())
			.mainChecked(mediaRequestVo.getMainChecked())
			.detailChecked(mediaRequestVo.getDetailChecked())
			.productChecked(mediaRequestVo.getProductChecked())
			.productUUID( mediaRequestVo.getProductUUID())
			.build();
	}


	public ProductMedia toEntity() {

		return ProductMedia.builder()
			.productUUID(productUUID)
			.path(path)
			.thumbChecked(thumbChecked)
			.mainChecked(mainChecked)
			.detailChecked(detailChecked)
			.productChecked(productChecked)
			.productUUID(productUUID)
			.build();
	}

}
