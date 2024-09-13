package TRaMis8khae.starbucks.product.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.dto.MediaRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductOptionRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.vo.MediaRequestVo;
import TRaMis8khae.starbucks.product.vo.ProductOptionRequestVo;
import TRaMis8khae.starbucks.product.vo.ProductRequestVo;
import TRaMis8khae.starbucks.product.vo.ProductResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public CommonResponseEntity<Void> createProduct(@RequestBody ProductRequestVo productRequestVo) {

        log.info("productRequestVo : {}", productRequestVo);
        productService.addProduct(ProductRequestDto.toDto(productRequestVo));

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                "상품 등록 성공",
                null
        );
    }


    @PostMapping("/media")
    public CommonResponseEntity<Void> createProductMedia(@RequestBody MediaRequestVo mediaRequestVo) {

        productService.addMedia(MediaRequestDto.toDto(mediaRequestVo));

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            "미디어 등록 성공",
            null
        );
    }


    @PostMapping("/option")
    public CommonResponseEntity<Void> createProductOption(@RequestBody ProductOptionRequestVo productOptionRequestVo) {

        productService.addProductOption(ProductOptionRequestDto.toDto(productOptionRequestVo));

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            "상품 옵션 등록 성공",
            null
        );
    }

    @DeleteMapping
    public CommonResponseEntity<Void> deleteProduct(@RequestBody String productUUID) {
        productService.deleteProduct(productUUID);

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            "상품 삭제 성공",
            null
        );
    }

    @DeleteMapping("/media")
    public CommonResponseEntity<Void> deleteMedia(@RequestBody String productUUID) {

        productService.deleteMedia(productUUID);

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            "상품 삭제 성공",
            null
        );
    }

    @DeleteMapping("/option")
    public CommonResponseEntity<Void> deleteOption(@RequestBody String productUUID) {

        productService.deleteProductOption(productUUID);

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            "상품 삭제 성공",
            null
        );
    }


    @GetMapping("/{productUUID}")
    public CommonResponseEntity<ProductResponseVo> getProduct(@PathVariable String productUUID) {

        ProductResponseDto productResponseDto = productService.findProduct(productUUID);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                "상품 조회 성공",
                productResponseDto.toVo()
        );
    }

    @GetMapping("/productList")
    public CommonResponseEntity<List<ProductResponseVo>> getProducts() {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                "상품 리스트 조회 성공",
                productService.findProducts().stream().map(ProductResponseDto::toVo).toList()
        );
    }

}