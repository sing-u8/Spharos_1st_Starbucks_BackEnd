package TRaMis8khae.starbucks.vendor.presentation;

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
	public CommonResponseEntity<Void> createProductByCategory(@RequestBody ProductCategoryListRequestVo productCategoryListRequestVo) {

		productCategoryListService.addProductByCategory(ProductCategoryListRequestDto.toDto(productCategoryListRequestVo));

		return new CommonResponseEntity<>(
			HttpStatus.OK,
			true,
			CommonResponseMessage.SUCCESS.getMessage(),
			null
		);
	}

	@GetMapping("/{topCode}/products")
	public CommonResponseEntity<List<ProductCategoryListResponseVo>> getProductsByTopCategory(@PathVariable String topCode) {

		return new CommonResponseEntity<>(
			HttpStatus.OK,
			true,
			CommonResponseMessage.SUCCESS.getMessage(),
			productCategoryListService.findProductsByTopCategory(topCode).stream().map(ProductCategoryListResponseDto::toVo).toList()
		);
	}
//getProductByBottomCategory(bottomCode), 용량 - short 355미만, tall 473미만, grande 591미만, venti 591이상, 종류
}