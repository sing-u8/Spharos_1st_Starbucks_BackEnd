package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.dto.*;
import TRaMis8khae.starbucks.product.entity.*;
import TRaMis8khae.starbucks.product.infrastructure.*;
import TRaMis8khae.starbucks.product.vo.VolumeRequestVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final VolumeRepository volumeRepository;

    @Override
    public void addProduct(ProductRequestDto requestDto) {

        if (productRepository.existsByproductName(requestDto.getProductName())) {
            throw new IllegalArgumentException("해당 상품이 이미 존재합니다");
        }

        String productUUID = UUID.randomUUID().toString();

        productRepository.save(requestDto.toEntity(productUUID));
    }

//    @Override
//    public void updateProduct(ProductRequestDto requestDto) {
//
//        productRepository.findByProductUUID(requestDto.getProductUUID())
//                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
//
//        productRepository.save(requestDto.toEntity(requestDto.getProductUUID()));
//    }

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

        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductResponseDto::toDto).toList();
    }

    @Override
    @Transactional
    public void addProductOption(ProductOptionRequestDto requestDto) {

        if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
            throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
        }

        Volume volume = requestDto.toVolumeEntity();
        volumeRepository.save(volume);

        productOptionRepository.save(requestDto.toEntity(volume));

    }


//    @Override
//    public void updateProductOption(ProductOptionRequestDto requestDto) {
//
//
//    }


    @Transactional
    @Override
    public void deleteProductOption(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new IllegalArgumentException("해당 상품이 존재하지 않습니다.")
        );

        volumeRepository.delete(productOption.getVolume());
        productOptionRepository.delete(productOption);
    }

    @Override
    public ProductOptionResponseDto findProductOption(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new IllegalArgumentException("해당 상품이 존재하지 않습니다.")
        );

        return ProductOptionResponseDto.toDto(productOption);
    }

    @Override
    public VolumeResponseDto findVolume(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new IllegalArgumentException("해당 상품이 존재하지 않습니다.")
        );

        return VolumeResponseDto.toDto(productOption.getVolume());
    }

    @Override
    public List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice) {

        List<Product> products = productRepositoryCustom.getProductListWithPrice(MinPrice, MaxPrice);

        return products.stream().map(ProductResponseDto::toDto).toList();
    }


    @Override
    public void addMedia(MediaRequestDto requestDto) {

        if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
            throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
        }

        mediaRepository.save(requestDto.toEntity());
    }



    @Override
    public void deleteMedia(String productUUID) {

        if (!productRepository.existsByProductUUID(productUUID)) {
            throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
        }

        mediaRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new IllegalArgumentException("해당 상품의 이미지를 찾을 수 없습니다.")
        );
    }


    @Override
    public MediaResponseDto findDetailMedia(String productUUID) {

        ProductMedia productMedia = mediaRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new IllegalArgumentException("해당 상품의 이미지를 찾을 수 없습니다.")
        );

        if (productMedia.getProductChecked() == Boolean.FALSE) {
            return null;
        }

        return MediaResponseDto.builder().build();
    }


    @Override //썸네일
    public MediaResponseDto findMedia(String productUUID) {

        ProductMedia productMedia = mediaRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new IllegalArgumentException("해당 상품의 이미지를 찾을 수 없습니다.")
        );

        if (productMedia.getProductChecked() == Boolean.FALSE) {
            return null;
        }

        if (productMedia.getThumbChecked() == Boolean.FALSE) {
            return null;
        }

        return MediaResponseDto.builder().build();
    }
}