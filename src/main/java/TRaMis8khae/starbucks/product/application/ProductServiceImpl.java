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
import TRaMis8khae.starbucks.product.infrastructure.ProductRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;
    private final MediaRepository mediaRepository;
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
        ProductMedia productMedia = mediaRepository.findByProductUUID(productUUID)
            .orElseThrow(() -> new IllegalArgumentException("해당 상품의 이미지가 존재하지 않습니다."));
        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID)
            .orElseThrow(() -> new IllegalArgumentException("해당 상품의 옵션이 존재하지 않습니다."));

        return ProductResponseDto.toDto(product, productOption, productMedia);
    }

    @Override
    public List<ProductResponseDto> findProducts() {

        List<Product> products = productRepository.findAll();
        List<ProductMedia> productsMedia = mediaRepository.findAll();
        List<ProductOption> productOptions = productOptionRepository.findAll();


        return null;
    }

    public List<ProductDetailResponseDto> findDetailProduct(String productUUID) {

        return null;
    }

    public List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice) {

        List<Product> products = productRepositoryCustom.getProductListWithPrice(MinPrice, MaxPrice);

//        return products.stream().map(ProductResponseDto::toDto).toList();
        return null;
    }

}