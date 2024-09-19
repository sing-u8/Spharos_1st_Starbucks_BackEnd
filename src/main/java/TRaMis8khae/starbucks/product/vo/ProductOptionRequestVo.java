package TRaMis8khae.starbucks.product.vo;


import lombok.Getter;


@Getter
public class ProductOptionRequestVo {

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

}
