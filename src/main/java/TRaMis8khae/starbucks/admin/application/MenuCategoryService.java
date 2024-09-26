package TRaMis8khae.starbucks.admin.application;


import TRaMis8khae.starbucks.admin.dto.in.MenuCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.MenuCategoryResponseDto;

import java.util.List;


public interface MenuCategoryService {

	void addMenuCategory(MenuCategoryRequestDto requestDto);

	List<MenuCategoryResponseDto> findMenuCategories();

}
