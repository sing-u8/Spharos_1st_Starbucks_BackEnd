package TRaMis8khae.starbucks.product.vo.out;


import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class ProductDetailResponseVo {

	private String productName;

	private String description;

	private Double price;

	private Boolean isAdditionalTogether;

	private Boolean additionalChecked;

	private Integer maxOrderCount;

	private Long thumbId;

	private List<Long> detailIds;
}
