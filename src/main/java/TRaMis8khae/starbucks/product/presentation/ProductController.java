package TRaMis8khae.starbucks.product.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
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
    public BaseResponse<Void> createProduct(@RequestBody ProductRequestVo productRequestVo) {

        log.info("productRequestVo : {}", productRequestVo);
        productService.addProduct(ProductRequestDto.toDto(productRequestVo));

        return new BaseResponse<>();
    }


    @PostMapping("/media")
    public BaseResponse<Void> createProductMedia(@RequestBody MediaRequestVo mediaRequestVo) {

        productService.addMedia(MediaRequestDto.toDto(mediaRequestVo));

        return new BaseResponse<>();
    }


    @PostMapping("/option")
    public BaseResponse<Void> createProductOption(@RequestBody ProductOptionRequestVo productOptionRequestVo) {

        productService.addProductOption(ProductOptionRequestDto.toDto(productOptionRequestVo));

        return new BaseResponse<>();
    }

    @DeleteMapping
    public BaseResponse<Void> deleteProduct(@RequestBody String productUUID) {
        productService.deleteProduct(productUUID);

        return new BaseResponse<>();
    }

    @DeleteMapping("/media")
    public BaseResponse<Void> deleteMedia(@RequestBody String productUUID) {

        productService.deleteMedia(productUUID);

        return new BaseResponse<>();
    }

    @DeleteMapping("/option")
    public BaseResponse<Void> deleteOption(@RequestBody String productUUID) {

        productService.deleteProductOption(productUUID);

        return new BaseResponse<>();
    }


    @GetMapping("/{productUUID}")
    public BaseResponse<ProductResponseVo> getProduct(@PathVariable String productUUID) {

        ProductResponseDto productResponseDto = productService.findProduct(productUUID);

        return new BaseResponse<>(productResponseDto.toVo());
    }

    @GetMapping("/productList")
    public BaseResponse<List<ProductResponseVo>> getProducts() {
        return new BaseResponse<>(productService.findProducts().stream().map(
            ProductResponseDto::toVo).toList());
    }

}