package TRaMis8khae.starbucks.vendor.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.common.utils.CursorPage;
import TRaMis8khae.starbucks.vendor.application.ProductCategoryListService;
import TRaMis8khae.starbucks.vendor.dto.in.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.vo.in.ProductCategoryListRequestVo;
import TRaMis8khae.starbucks.vendor.vo.out.ProductCategoryListResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductCategoryListController {

	private final ProductCategoryListService productCategoryListService;

	@PostMapping("/category")
	@Operation(summary = "카테고리 별 상품 추가", description = "카테고리 별 상품을 추가합니다", tags = {"Product Category Service"})
	public BaseResponse<Void> createProductByCategory(@RequestBody ProductCategoryListRequestVo productCategoryListRequestVo) {

		productCategoryListService.addProductByCategory(
			ProductCategoryListRequestDto.toDto(productCategoryListRequestVo)
		);

		return new BaseResponse<>();
	}

	@GetMapping("/products")
	@Operation(summary = "카테고리 별 상품리스트 조회", description = "카테고리 별 상품리스트를 조회합니다", tags = {"Product Category Service"})
	public BaseResponse<CursorPage<String>> getProductCategoryListByCategories(
		@RequestParam( value = "topCategoryCode", required = false ) String topCategoryCode,
		@RequestParam( value = "middleCategoryCode", required = false ) String middleCategoryCode,
		@RequestParam( value = "bottomCategoryCode", required = false ) String bottomCategoryCode,
		@RequestParam( value = "lastId", required = false ) Long lastId,
		@RequestParam( value = "pageSize", required = false ) Integer pageSize,
		@RequestParam( value = "page", required = false ) Integer page
	) {

		return new BaseResponse<>(
			productCategoryListService.getProductCategoryListByCategories(
				topCategoryCode,
				middleCategoryCode,
				bottomCategoryCode,
				lastId,
				pageSize,
				page
			)
		);

	}

}