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

		productCategoryListService.addProductByCategory(ProductCategoryListRequestDto.toDto(productCategoryListRequestVo));

		return new BaseResponse<>();
	}

	@GetMapping("/{topCode}/products")
	public BaseResponse<List<ProductCategoryListResponseVo>> getProductsByTopCategories(@PathVariable String topCode) {

		return new BaseResponse<>(productCategoryListService.findProductsByTopCategory(topCode).stream().map(ProductCategoryListResponseDto::toVo).toList());
	}

}