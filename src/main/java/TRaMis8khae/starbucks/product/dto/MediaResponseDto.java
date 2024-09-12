package TRaMis8khae.starbucks.product.dto;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.ProductMedia;
import TRaMis8khae.starbucks.product.vo.MediaResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MediaResponseDto {

	private String path;

	private Boolean thumbChecked;

	private Boolean mainChecked;

	private Boolean detailChecked;

	//if productChecked == true 일 경우
	public static MediaResponseDto toDto(ProductMedia productMedia) {

		return MediaResponseDto.builder()
			.path(productMedia.getPath())
			.thumbChecked(productMedia.getThumbChecked())
			.mainChecked(productMedia.getMainChecked())
			.detailChecked(productMedia.getDetailChecked())
			.build();
	}


	public MediaResponseVo toVo() {

		return MediaResponseVo.builder()
			.path(path)
			.thumbChecked(thumbChecked)
			.mainChecked(mainChecked)
			.detailChecked(detailChecked)
			.build();
	}

}
