package TRaMis8khae.starbucks.product.vo.out;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductDetailResponseVo {

	private String productName;

	private String description;

	private Double price;

	private Double productScore;

	private Boolean isAdditionalTogether;

	private Boolean additionalChecked;

	private Integer maxOrderCount;

}
