package TRaMis8khae.starbucks.product.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.media.application.MediaService;
import TRaMis8khae.starbucks.product.application.ProductOptionService;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.dto.*;
import TRaMis8khae.starbucks.product.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    private final MediaService mediaService;
    private final ProductOptionService productOptionService;
//    private final ProductAdditionalProductListServiceImpl additionalProductService;

    @PostMapping
    public BaseResponse<Void> createProduct(@RequestBody ProductRequestVo productRequestVo) {

        log.info("productRequestVo : {}", productRequestVo);
        productService.addProduct(ProductRequestDto.toDto(productRequestVo));

        return new BaseResponse<>();
    }

    @PostMapping("/update")
    public BaseResponse<Void> updateProduct(@RequestParam String UUID, @RequestBody ProductUpdateRequestVo requestVo) {

        log.info("productRequestVo : {}", requestVo);
        productService.updateProduct(UUID, ProductUpdateRequestDto.toDto(requestVo));

        return new BaseResponse<>();
    }

    @PostMapping("/option")
    public BaseResponse<Void> createProductOption(@RequestBody ProductOptionRequestVo productOptionRequestVo) {

        productOptionService.addProductOption(ProductOptionRequestDto.toDto(productOptionRequestVo));

        return new BaseResponse<>();
    }

    @DeleteMapping
    public BaseResponse<Void> deleteProduct(@RequestBody String productUUID) {
        productService.deleteProduct(productUUID);

        return new BaseResponse<>();
    }

    @DeleteMapping("/option")
    public BaseResponse<Void> deleteOption(@RequestBody String productUUID) {

        productOptionService.deleteProductOption(productUUID);

        return new BaseResponse<>();
    }


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
//    @PostMapping("/additional")
//    public BaseResponse<Void> addAdditionalProduct(@RequestBody ProductAdditionalProductListRequestVo requestVo) {
//
//        additionalProductService.addProductAdditionalProduct(ProductAdditionalProductListRequestDto.toDto(requestVo));
//
//        return new BaseResponse<>();
//    }
//
//    @GetMapping("/additionProducts/{productUUID}")
//    public BaseResponse<List<ProductResponseVo>> getAdditionProducts(@PathVariable String productUUID) {
//        return new BaseResponse<>(productService.findProductDtosByProductUUID(
//                additionalProductService.findProductAdditionalProduct(productUUID))
//                .stream()
//                .map(ProductResponseDto::toVo).toList()
//        );
//    }

}