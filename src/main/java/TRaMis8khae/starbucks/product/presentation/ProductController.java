package TRaMis8khae.starbucks.product.presentation;

import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.vo.ProductRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

//    @PostMapping
//    public CommonResponseEntity<Void> createProduct(@RequestBody ProductRequestVo productRequestVo) {
//        log.info("productRequestVo : {}", productRequestVo);
//        ProductRequestDto productRequestDto = ProductRequestDto.builder()
//                .productName(productRequestVo.getProductName())
//                .date(productRequestVo.getDate())
//                .build();
//        productService.addProduct(productRequestDto);
//        return new CommonResponseEntity<>(
//                HttpStatus.OK,
//                "상품 등록 성공",
//                null
//        );
//    }
//
//    @DeleteMapping
//    public CommonResponseEntity<Void> deleteProduct() {
//
//        return null;
//    }


}
