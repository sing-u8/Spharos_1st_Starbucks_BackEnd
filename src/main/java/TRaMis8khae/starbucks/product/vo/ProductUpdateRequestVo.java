package TRaMis8khae.starbucks.product.vo;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductUpdateRequestVo {

	private String productUUID;

	private String productName;

	private Double price;

	private Boolean additionalChecked;

	private Boolean isAdditionalTogether;

	private Integer maxOrderCount;

	private Boolean engravingChecked;
}
