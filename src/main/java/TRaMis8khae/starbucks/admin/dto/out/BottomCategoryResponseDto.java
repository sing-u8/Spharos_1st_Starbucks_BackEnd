package TRaMis8khae.starbucks.admin.dto.out;


import TRaMis8khae.starbucks.admin.entity.BottomCategory;
import TRaMis8khae.starbucks.admin.vo.BottomCategoryResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BottomCategoryResponseDto {

	private String name;
	private String code;

	public static BottomCategoryResponseDto toDto(BottomCategory bottomCategory) {
		return BottomCategoryResponseDto.builder()
			.name(bottomCategory.getName())
			.code(bottomCategory.getCode())
			.build();
	}

	public BottomCategoryResponseVo toVo() {
		return BottomCategoryResponseVo.builder()
			.code(code)
			.name(name)
			.build();
	}
}
