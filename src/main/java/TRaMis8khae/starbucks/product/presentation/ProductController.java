package TRaMis8khae.starbucks.product.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.vo.in.ProductRequestVo;
import TRaMis8khae.starbucks.product.vo.out.ProductResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

//    @GetMapping("/productList")
//    public BaseResponse<List<ProductResponseVo>> getProducts() {
//        return new BaseResponse<>(productService.findProducts().stream().map(
//            ProductResponseDto::toVo).toList());
//    }
//


    @Operation(summary = "상품 가격별 분류", description = "상품을 가격별로 분류합니다", tags = {"Product Service"})
    @GetMapping("/price")
    public BaseResponse<List<ProductResponseVo>> getProductsWithPrice(@RequestParam Double minPrice, @RequestParam Double maxPrice) {

        return new BaseResponse<>(productService.findByPrice(minPrice, maxPrice)
            .stream().map(ProductResponseDto::toVo).toList());
    }

    @Operation(summary = "용량별 상품 분류", description = "용량별로 상품을 분류합니다", tags = {"Product Service"})
    @GetMapping("/volume")
    public BaseResponse<List<ProductResponseVo>> getProductsWithVolume(@RequestParam String volumeName) {

        return new BaseResponse<>(productService.findProductsByVolume(volumeName)
            .stream().map(ProductResponseDto::toVo).toList());
    }

}