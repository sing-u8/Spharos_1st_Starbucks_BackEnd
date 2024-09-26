package TRaMis8khae.starbucks.product.vo.in;


import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ProductMediaListRequestVo {

	private String productUUID;

	private Long mediaId;

}
