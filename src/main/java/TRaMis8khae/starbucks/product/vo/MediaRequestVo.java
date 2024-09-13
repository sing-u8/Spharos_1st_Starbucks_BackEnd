package TRaMis8khae.starbucks.product.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MediaRequestVo {

	private String path;

	private Boolean thumbChecked;

	private Boolean mainChecked;

	private Boolean detailChecked;

	private Boolean productChecked;

	private String productUUID;

}
