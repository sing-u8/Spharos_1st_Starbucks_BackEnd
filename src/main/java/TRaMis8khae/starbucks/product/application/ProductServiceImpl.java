package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.domain.Product;
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
        String productUuid = UUID.randomUUID().toString();
        productRepository.save(requestDto.toEntity(productUuid));
    }

    @Override
    public void updateProduct(ProductRequestDto requestDto) {
        productRepository.findByProductUuid(requestDto.getProductUuid())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.save(requestDto.toEntity(requestDto.getProductUuid()));
    }


    @Override
    public void deleteProduct(String productUuid) {
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        System.out.println(product.getProductName());
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .date(product.getDate())
                .productUuid(productUuid)
                .productScore(product.getProductScore())
                .build();
    }

    @Override
    public List<ProductResponseDto> getProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponseDto> productResponseDtoList = products.stream()
                .map(product -> ProductResponseDto.builder()
                        .productUuid(product.getProductUuid())
                        .productName(product.getProductName())
                        .productScore(product.getProductScore())
                        .build())
                .toList();

        return List.of();
    }


}
