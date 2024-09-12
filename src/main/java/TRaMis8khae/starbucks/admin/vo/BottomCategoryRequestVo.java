package TRaMis8khae.starbucks.admin.vo;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class BottomCategoryRequestVo {

	private String name;

	private Integer sequence;

	private String middleCategoryCode;
}
