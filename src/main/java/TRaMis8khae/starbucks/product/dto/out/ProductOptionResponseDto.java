package TRaMis8khae.starbucks.product.dto.out;


import TRaMis8khae.starbucks.product.entity.ProductOption;
import TRaMis8khae.starbucks.product.vo.out.ProductOptionResponseVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductOptionResponseDto {

	private String productName;

	private Double price;

	private Integer stockQuantity;

	private Integer limitCnt;

	private Boolean soldOutChecked;

	private Boolean closedChecked;

	private Boolean openChecked;

	public static ProductOptionResponseDto toDto(ProductOption productOption) {
//volume name, color name        //volume, color 객체
		return ProductOptionResponseDto.builder()
			.productName(productOption.getProductName())
			.price(productOption.getPrice())
			.stockQuantity(productOption.getStockQuantity())
			.limitCnt(productOption.getLimitCnt())
			.soldOutChecked(productOption.getSoldOutChecked())
			.closedChecked(productOption.getClosedChecked())
			.openChecked(productOption.getOpenChecked())
			.build();
	}

	public ProductOptionResponseVo toVo() {

		return ProductOptionResponseVo.builder()
			.productName(productName)
			.price(price)
			.stockQuantity(stockQuantity)
			.limitCnt(limitCnt)
			.soldOutChecked(soldOutChecked)
			.closedChecked(closedChecked)
			.openChecked(openChecked)
			.build();
	}

}
