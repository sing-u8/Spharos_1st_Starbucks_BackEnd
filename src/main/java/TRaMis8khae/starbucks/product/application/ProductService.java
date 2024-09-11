package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDto requestDto);

    void updateProduct(ProductRequestDto requestDto);

    void deleteProduct(String productUUID);

    ProductResponseDto findProduct(String productUUID);

    List<ProductResponseDto> findProducts();

    List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice);

}