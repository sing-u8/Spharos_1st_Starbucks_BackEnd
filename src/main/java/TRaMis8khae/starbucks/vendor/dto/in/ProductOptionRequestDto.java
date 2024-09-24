package TRaMis8khae.starbucks.vendor.dto.in;


import TRaMis8khae.starbucks.vendor.entity.Color;
import TRaMis8khae.starbucks.vendor.entity.ProductOption;
import TRaMis8khae.starbucks.vendor.entity.Volume;
import TRaMis8khae.starbucks.vendor.vo.in.ProductOptionRequestVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductOptionRequestDto {

	private String productName;

	private Double price;

	private Integer stockQuantity;

	private Integer limitCnt;

	private Boolean soldOutChecked;

	private Boolean closedChecked;

	private Boolean openChecked;

	private String productUUID;

	private String volumeName;

	private String colorName;


	public static ProductOptionRequestDto toDto(ProductOptionRequestVo productOptionRequestVo) {

		return ProductOptionRequestDto.builder()
			.productName(productOptionRequestVo.getProductName())
			.price(productOptionRequestVo.getPrice())
			.stockQuantity(productOptionRequestVo.getStockQuantity())
			.limitCnt(productOptionRequestVo.getLimitCnt())
			.soldOutChecked(productOptionRequestVo.getSoldOutChecked())
			.closedChecked(productOptionRequestVo.getClosedChecked())
			.openChecked(productOptionRequestVo.getOpenChecked())
			.productUUID(productOptionRequestVo.getProductUUID())
			.volumeName(productOptionRequestVo.getVolumeName())
			.colorName(productOptionRequestVo.getColorName())
			.build();
	}

	public ProductOption toEntity(Volume volume, Color color) {

		return ProductOption.builder()
			.productUUID(productUUID)
			.productName(productName)
			.price(price)
			.stockQuantity(stockQuantity)
			.limitCnt(limitCnt)
			.soldOutChecked(soldOutChecked)
			.closedChecked(closedChecked)
			.openChecked(openChecked)
			.volume(volume)
			.color(color)
			.build();
	}

}
