package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.domain.Product;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequestDto requestDto) {
        UUID productUuid;
        productUuid = UUID.randomUUID();

        productRepository.save(requestDto.toEntity(productUuid));
    }

    @Override
    public void updateProduct(ProductRequestDto requestDto) {
        productRepository.findByProductUuid(requestDto.getProductUuid())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.save(requestDto.toEntity(requestDto.getProductUuid()));
    }


    @Override
    public void deleteProduct(UUID productUuid) {
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto getProduct(UUID productUuid) {
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .date(product.getDate())
                .productUuid(productUuid)
                .productScore(product.getProductScore())
                .build();
    }

    @Override
    public ProductResponseDto getProductDetail(UUID productUuid) {
        return null;
    }
}
