package TRaMis8khae.starbucks.product.presentation;


import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.vo.ProductRequestVo;
import TRaMis8khae.starbucks.product.vo.ProductResponseVo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public CommonResponseEntity<Void> createProduct(@RequestBody ProductRequestVo productRequestVo) {
        log.info("productRequestVo : {}", productRequestVo);
        productService.addProduct(ProductRequestDto.toDto(productRequestVo));
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 등록 성공",
                null
        );
    }

    @DeleteMapping
    public CommonResponseEntity<Void> deleteProduct(@RequestBody String productUUID) {
        productService.deleteProduct(productUUID);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 삭제 성공",
                null
        );
    }

//    @PutMapping
//    public CommonResponseEntity<Void> updateProduct(@RequestBody ProductRequestVo productRequestVo) {
//
//        return null;
//    }

    @GetMapping("/{productUUID}")
    public CommonResponseEntity<ProductResponseVo> getProduct(@PathVariable String productUUID) {
        ProductResponseDto productResponseDto = productService.findProduct(productUUID);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                productResponseDto.toVo()
                );
    }

    @GetMapping("/productList")
    public CommonResponseEntity<List<ProductResponseVo>> getProducts() {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 리스트 조회 성공",
                productService.findProducts().stream().map(ProductResponseDto::toVo).toList()
        );
    }

}
