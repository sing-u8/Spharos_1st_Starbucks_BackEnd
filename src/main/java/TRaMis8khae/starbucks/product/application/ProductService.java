package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;

import java.util.UUID;

public interface ProductService {
    void addProduct(ProductRequestDto requestDto);
    void updateProduct(ProductRequestDto requestDto);
    void deleteProduct(UUID productUuid);
    ProductResponseDto getProduct(UUID productUuid);
    ProductResponseDto getProductDetail(UUID productUuid);
}
