package TRaMis8khae.starbucks.product.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MediaResponseDto {

	private String path;

	private Boolean thumbChecked;

	private Boolean mainChecked;

	private Boolean detailChecked;

	private Boolean productChecked;

	private String productUUID;

}
