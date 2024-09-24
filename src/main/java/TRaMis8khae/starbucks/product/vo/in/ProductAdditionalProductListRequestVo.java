package TRaMis8khae.starbucks.product.vo.in;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductAdditionalProductListRequestVo {

	private String productUUID;

	private String additionalUUID;

}
