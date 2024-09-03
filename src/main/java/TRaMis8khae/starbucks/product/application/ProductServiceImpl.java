package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequestDto requestDto) {
        String productUUID = UUID.randomUUID().toString();
        productRepository.save(requestDto.toEntity(productUUID));
    }

    @Override
    public void updateProduct(ProductRequestDto requestDto) {
        productRepository.findByProductUUID(requestDto.getProductUUID())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.save(requestDto.toEntity(requestDto.getProductUUID()));

    }


    @Override
    public void deleteProduct(String productUUID) {
        Product product = productRepository.findByProductUUID(productUUID)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto findProduct(String productUUID) {
        Product product = productRepository.findByProductUUID(productUUID)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .date(product.getDate())
                .productUUID(productUUID)
                .productScore(product.getProductScore())
                .build();
    }

    @Override
    public List<ProductResponseDto> findProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> ProductResponseDto.builder()
                        .productUUID(product.getProductUUID())
                        .productName(product.getProductName())
                        .productScore(product.getProductScore())
                        .build())
                .toList();
    }


}
