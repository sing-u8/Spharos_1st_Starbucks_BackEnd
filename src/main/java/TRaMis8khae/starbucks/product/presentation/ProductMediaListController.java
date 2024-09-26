package TRaMis8khae.starbucks.product.presentation;


import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.product.application.ProductMediaService;
import TRaMis8khae.starbucks.product.dto.in.ProductMediaListRequestDto;
import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductMediaListResponseDto;
import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.infrastructure.ProductMediaListRepository;
import TRaMis8khae.starbucks.product.vo.in.ProductMediaListRequestVo;
import TRaMis8khae.starbucks.product.vo.in.ProductRequestVo;
import TRaMis8khae.starbucks.product.vo.out.ProductMediaListResponseVo;
import TRaMis8khae.starbucks.product.vo.out.ProductResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/productMedia")
public class ProductMediaListController {

	private final ProductMediaService productMediaService;

	@Operation(summary = "상품 미디어 추가", description = "상품 미디어를 추가합니다", tags = {"Product Service"})
	@PostMapping
	public BaseResponse<Void> createProductMedia(@RequestBody ProductMediaListRequestVo requestVo) {

		productMediaService.addProductMedia(ProductMediaListRequestDto.toDto(requestVo));

		return new BaseResponse<>();
	}

	@Operation(summary = "상품 미디어 리스트 가져오기", description = "상품 미디어 리스트를 가져옵니다", tags = {"Product Service"})
	@GetMapping("/{productUUID}")
	public BaseResponse<List<ProductMediaListResponseVo>> getProduct(@PathVariable String productUUID) {

		return new BaseResponse<>(productMediaService.findProductMedia(productUUID).stream().map(
			ProductMediaListResponseDto::toVo).toList()
		);
	}
}
