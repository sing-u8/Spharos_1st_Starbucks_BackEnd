package TRaMis8khae.starbucks.admin.dto.in;


import TRaMis8khae.starbucks.admin.entity.MenuCategory;
import TRaMis8khae.starbucks.admin.vo.MenuCategoryRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategoryRequestDto {

	private String topCode;

	private String imageUrl;


	public static MenuCategoryRequestDto toDto(MenuCategoryRequestVo requestVo) {

		return MenuCategoryRequestDto.builder()
			.topCode(requestVo.getTopCode())
			.imageUrl(requestVo.getImageUrl())
			.build();
	}


	public MenuCategory toEntity() {

		return MenuCategory.builder()
			.topCode(topCode)
			.imageUrl(imageUrl)
			.build();
	}
}
