package TRaMis8khae.starbucks.product.vo.out;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductDetailResponseVo {

	private String description;

	private Double productScore;

	private Boolean isAdditionalTogether;

	private Integer maxOrderCount;

}
