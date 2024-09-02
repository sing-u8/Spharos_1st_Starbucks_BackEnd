package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.domain.Product;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void addProduct(ProductRequestDto requestDto);
    void updateProduct(ProductRequestDto requestDto);
    void deleteProduct(String productUuid);
    ProductResponseDto getProduct(String productUuid);
    List<ProductResponseDto> getProducts();
}
