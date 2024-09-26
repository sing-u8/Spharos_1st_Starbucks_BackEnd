package TRaMis8khae.starbucks.admin.dto.out;


import TRaMis8khae.starbucks.admin.entity.MenuCategory;
import TRaMis8khae.starbucks.admin.vo.MenuCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategoryResponseDto {

	private String topCode;

	private String imageUrl;


	public static MenuCategoryResponseDto toDto(MenuCategory menuCategory) {

		return MenuCategoryResponseDto.builder()
			.topCode(menuCategory.getTopCode())
			.imageUrl(menuCategory.getImageUrl())
			.build();
	}


	public MenuCategoryResponseVo toVo() {

		return MenuCategoryResponseVo.builder()
			.topCode(topCode)
			.imageUrl(imageUrl)
			.build();
	}

}
