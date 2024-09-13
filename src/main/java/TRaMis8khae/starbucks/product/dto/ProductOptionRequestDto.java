package TRaMis8khae.starbucks.product.dto;


import TRaMis8khae.starbucks.product.entity.Engraving;
import TRaMis8khae.starbucks.product.entity.ProductOption;
import TRaMis8khae.starbucks.product.entity.Volume;
import TRaMis8khae.starbucks.product.vo.ProductOptionRequestVo;
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
			.build();
	}


	public Volume toVolumeEntity() {

		return Volume.builder().name(volumeName).build();
	}


	public ProductOption toEntity(Volume volume) {

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
			.build();
	}

}
