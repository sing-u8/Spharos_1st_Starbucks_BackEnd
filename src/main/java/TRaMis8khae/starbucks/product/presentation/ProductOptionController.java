package TRaMis8khae.starbucks.product.presentation;


import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.product.application.ProductOptionService;
import TRaMis8khae.starbucks.product.dto.in.ProductOptionRequestDto;
import TRaMis8khae.starbucks.product.vo.in.ProductOptionRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-option")
public class ProductOptionController {

	private final ProductOptionService productOptionService;

	@Operation(summary = "상품 옵션 추가", description = "상품의 옵션을 추가합니다", tags = {"Product Option Service"})
	@PostMapping("/option")
	public BaseResponse<Void> createProductOption(@RequestBody ProductOptionRequestVo productOptionRequestVo) {

		productOptionService.addProductOption(ProductOptionRequestDto.toDto(productOptionRequestVo));

		return new BaseResponse<>();
	}

	@DeleteMapping("/option")
	public BaseResponse<Void> deleteOption(@RequestBody String productUUID) {

		productOptionService.deleteProductOption(productUUID);

		return new BaseResponse<>();
	}

}
