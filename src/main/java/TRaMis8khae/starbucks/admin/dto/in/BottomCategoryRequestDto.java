package TRaMis8khae.starbucks.admin.dto.in;


import TRaMis8khae.starbucks.admin.entity.BottomCategory;
import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import TRaMis8khae.starbucks.admin.vo.BottomCategoryRequestVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class BottomCategoryRequestDto {

	private String name;
	private Integer sequence;
	private String middleCategoryCode;


	public static BottomCategoryRequestDto toDto(BottomCategoryRequestVo bottomCategoryRequestVo) {
		return BottomCategoryRequestDto.builder()
			.name(bottomCategoryRequestVo.getName())
			.sequence(bottomCategoryRequestVo.getSequence())
			.middleCategoryCode(bottomCategoryRequestVo.getMiddleCategoryCode())
			.build();
	}

	public BottomCategory toEntity(MiddleCategory middleCategory, String code) {
		return BottomCategory.builder()
			.name(name)
			.sequence(sequence)
			.middleCategory(middleCategory)
			.code(code)
			.build();
	}
}
