package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.dto.ProductDetailResponseDto;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.ProductMedia;
import TRaMis8khae.starbucks.product.entity.ProductOption;
import TRaMis8khae.starbucks.product.infrastructure.MediaRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductOptionRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;
    private final MediaRepository mediaRepository;

    @Override
    public void addProduct(ProductRequestDto requestDto) {

        if (productRepository.existsByproductName(requestDto.getProductName())) {
            throw new IllegalArgumentException("해당 상품이 이미 존재합니다");
        }

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
        ProductMedia productMedia = mediaRepository.findByProductUUID(productUUID)
            .orElseThrow(() -> new IllegalArgumentException("해당 상품의 미디어가 존재하지 않습니다."));
        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID)
            .orElseThrow(() -> new IllegalArgumentException("해당 상품의 옵션이 존재하지 않습니다."));

        return ProductResponseDto.builder()
            .productName(product.getProductName())
            .productUUID(productUUID)
            .price(product.getPrice())
            .thumbChecked(productMedia.getThumbChecked())
            .path(productMedia.getPath())
            .soldOutChecked(productOption.getSoldOutChecked())
            .openChecked(productOption.getOpenChecked())
            .build();
    }

    @Override
    public List<ProductResponseDto> findProducts() {

        List<Product> productList = productRepository.findAll();

//        return productList.stream().map(ProductResponseDto::toDto).toList();
        return null;
    }

    public List<ProductDetailResponseDto> findDetailProduct(String productUUID) {
        return null;
    }

}