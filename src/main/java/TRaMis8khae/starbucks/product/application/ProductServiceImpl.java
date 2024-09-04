package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.dto.ProductDetailInfoResponseDto;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.dto.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.ProductInfoList;
import TRaMis8khae.starbucks.product.entity.ProductOption;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepositoryCustom;
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
    private final ProductRepositoryCustom productRepositoryCustom;

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
        return ProductResponseDto.toDto(product);
    }

    @Override
    public List<ProductResponseDto> findProducts() {
        List<Product> productList = productRepository.findAll();

        return productList.stream().map(ProductResponseDto::toDto).toList();
    }

    public List<ProductDetailInfoResponseDto> findDetailProduct(String productUUID) {
        List<ProductOption> productOptionWithProduct = productRepositoryCustom.getProductOptionWithProduct(productUUID);
        List<ProductInfoList> productInfoWithProduct = productRepositoryCustom.getProductInfoWithProduct(productUUID);

        return null;
    }

}
