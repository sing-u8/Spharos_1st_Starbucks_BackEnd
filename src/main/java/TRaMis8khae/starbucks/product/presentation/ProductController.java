package TRaMis8khae.starbucks.product.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductDetailResponseDto;
import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.vo.in.ProductRequestVo;
import TRaMis8khae.starbucks.product.vo.out.ProductDetailResponseVo;
import TRaMis8khae.starbucks.product.vo.out.ProductResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 추가", description = "상품을 추가합니다", tags = {"Product Service"})
    @PostMapping
    public BaseResponse<Void> createProduct(@RequestBody ProductRequestVo productRequestVo) {

        log.info("productRequestVo : {}", productRequestVo);
        productService.addProduct(ProductRequestDto.toDto(productRequestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "상품 수정", description = "상품을 수정합니다", tags = {"Product Service"})
    @PostMapping("/update")
    public BaseResponse<Void> updateProduct(@RequestBody ProductRequestVo requestVo) {

        log.info("productRequestVo : {}", requestVo);
        productService.updateProduct(ProductRequestDto.toDto(requestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "상품 삭제", description = "상품을 삭제합니다", tags = {"Product Service"})
    @DeleteMapping
    public BaseResponse<Void> deleteProduct(@RequestBody String productUUID) {
        productService.deleteProduct(productUUID);

        return new BaseResponse<>();
    }

    @Operation(summary = "상품 가져오기", description = "상품을 가져옵니다", tags = {"Product Service"})
    @GetMapping("/{productUUID}")
    public BaseResponse<ProductResponseVo> getProduct(@PathVariable String productUUID) {

        ProductResponseDto productResponseDto = productService.findProduct(productUUID);

        return new BaseResponse<>(productResponseDto.toVo());
    }

    @Operation(summary = "상품 가격별 분류", description = "상품을 가격별로 분류합니다", tags = {"Product Service"})
    @GetMapping("/price")
    public BaseResponse<List<ProductResponseVo>> getProductsWithPrice(@RequestParam Double minPrice, @RequestParam Double maxPrice) {

        return new BaseResponse<>(productService.findByPrice(minPrice, maxPrice)
            .stream().map(ProductResponseDto::toVo).toList());
    }
    //이름, 가격, 썸네일(prouct media id)
    @Operation(summary = "상품 상세 조회하기", description = "상품 상세를 조회합니다", tags = {"Product Service"})
    @GetMapping("/{productUUID}")
    public BaseResponse<ProductDetailResponseVo> getDetailProduct(@PathVariable String productUUID) {

        ProductDetailResponseDto productDetailResponseDto = productService.findDetailProduct(productUUID);

        return new BaseResponse<>(productDetailResponseDto.toVo());
    }

}