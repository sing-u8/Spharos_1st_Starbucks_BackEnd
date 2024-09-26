package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.Product;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDto requestDto);

    void updateProduct(ProductRequestDto requestDto);

    void deleteProduct(String productUUID);

    ProductResponseDto findProduct(String productUUID);

    List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice);

    List<ProductResponseDto> findProductDtosByProductUUID(List<String> productUUID);

    List<Product> findProductsByProductUUID(List<String> productUUID);

}