package TRaMis8khae.starbucks.vendor.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.vendor.application.ProductCategoryListService;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.vo.ProductCategoryListRequestVo;
import TRaMis8khae.starbucks.vendor.vo.ProductCategoryListResponseVo;
import lombok.Getter;
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
	public BaseResponse<Void> createProductByCategory(@RequestBody ProductCategoryListRequestVo productCategoryListRequestVo) {

		productCategoryListService.addProductByCategory(
			ProductCategoryListRequestDto.toDto(productCategoryListRequestVo)
		);

		return new BaseResponse<>();
	}

	@GetMapping("/products")
	public BaseResponse<List<ProductCategoryListResponseVo>> getProductsByCategories(
		@RequestParam( value = "topCategoryCode", required = false ) String topCode,
		@RequestParam( value = "middleCategoryCode", required = false ) String middleCode,
		@RequestParam( value = "bottomCategoryCode", required = false ) String bottomCode) {

		return new BaseResponse<>(productCategoryListService.findProductsByCategories(
			topCode, middleCode, bottomCode)
			.stream().map(ProductCategoryListResponseDto::toVo).toList()
		);
	}

}