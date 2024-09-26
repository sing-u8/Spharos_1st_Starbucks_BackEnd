package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.*;
import TRaMis8khae.starbucks.product.infrastructure.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductRepositoryCustom productRepositoryCustom;

    @Override
    @Transactional
    public String addProduct(ProductRequestDto requestDto) {

        String productUUID = CodeGenerator.generateCode(36);

        if (productRepository.existsByProductUUID(productUUID)) {
            log.info(requestDto.getProductName());
            throw new BaseException(BaseResponseStatus.DUPLICATED_PRODUCT);
        }

        productRepository.save(requestDto.toEntity(productUUID));

        return productUUID;
    }

    @Override
    public void updateProduct(ProductRequestDto requestDto) {

        if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        productRepository.save(requestDto.toEntity(requestDto.getProductUUID()));
    }

    @Override
    public void deleteProduct(String productUUID) {

        Product product = productRepository.findByProductUUID(productUUID)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));

        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto findProduct(String productUUID) {

        Product product = productRepository.findByProductUUID(productUUID)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));

        return ProductResponseDto.toDto(product);
    }

    @Override
    public List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice) {

        List<Product> products = productRepositoryCustom.getProductListWithPrice(MinPrice, MaxPrice);

        return products.stream().map(ProductResponseDto::toDto).toList();
    }

    @Override
    public List<ProductResponseDto> findProductDtosByProductUUID(List<String> productUUID) {


        return productUUID.stream()
            .map(productRepository::findByProductUUID)
            .map(products -> products.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)))
            .map(ProductResponseDto::toDto).toList();
    }

    @Override
    public Slice<Product> findProductsByProductUUID(List<String> productUUID, Pageable pageable) {

        boolean hasNext = false;

        List<Product> products = productRepository.findByProductUUIDIn(productUUID, pageable);

        if (products.size() == pageable.getPageSize()) {
            hasNext = true;
        }

        return new SliceImpl<>(products, pageable, hasNext);
    }

}