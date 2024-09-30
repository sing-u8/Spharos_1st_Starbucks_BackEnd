package TRaMis8khae.starbucks.admin.presentation;


import TRaMis8khae.starbucks.admin.application.MenuCategoryService;
import TRaMis8khae.starbucks.admin.dto.in.MenuCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.MenuCategoryResponseDto;
import TRaMis8khae.starbucks.admin.infrastructure.MenuCategoryRepository;
import TRaMis8khae.starbucks.admin.vo.MenuCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.MenuCategoryResponseVo;
import TRaMis8khae.starbucks.admin.vo.TopCategoryRequestVo;
import TRaMis8khae.starbucks.common.entity.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class MenuCategoryController {

	private final MenuCategoryService menuCategoryService;


	@Operation(summary = "메뉴 카테고리 생성", description = "메뉴 카테고리를 생성합니다", tags = { "Category Service" })
	@PostMapping("/menuCategory")
	public BaseResponse<Void> createMenuCategory(@RequestBody MenuCategoryRequestVo menuCategoryRequestVo) {

		menuCategoryService.addMenuCategory(MenuCategoryRequestDto.toDto(menuCategoryRequestVo));

		return new BaseResponse<>();
	}


	@GetMapping
	@Operation(summary = "메뉴 카테고리 리스트 조회", description = "메뉴 카테고리 리스트를 조회합니다", tags = { "Category Service" })
	public BaseResponse<List<MenuCategoryResponseVo>> getMenuCategories() {

		return new BaseResponse<>(menuCategoryService.findMenuCategories().stream().map(
			MenuCategoryResponseDto::toVo
		).toList());
	}
}
