package TRaMis8khae.starbucks.product.presentation;


import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.product.application.ProductAdditionalProductListService;
import TRaMis8khae.starbucks.product.dto.in.ProductAdditionalProductListRequestDto;
import TRaMis8khae.starbucks.product.vo.in.ProductAdditionalProductListRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/additional-product")
public class ProductAdditionalProductListController {

	private final ProductAdditionalProductListService productAdditionalProductListService;

	@PostMapping
	public BaseResponse<Void> addAdditionalProduct(@RequestBody ProductAdditionalProductListRequestVo requestVo) {

		productAdditionalProductListService.addProductAdditionalProduct(ProductAdditionalProductListRequestDto.toDto(requestVo));

		return new BaseResponse<>();
	}

}
