package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.product.dto.*;
import TRaMis8khae.starbucks.product.entity.*;
import TRaMis8khae.starbucks.product.infrastructure.*;
import TRaMis8khae.starbucks.product.vo.ColorRequestVo;
import TRaMis8khae.starbucks.product.vo.VolumeRequestVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static TRaMis8khae.starbucks.product.dto.ColorRequestDto.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;
    private final MediaRepository mediaRepository;
    private final ProductRepositoryCustom productRepositoryCustom;
    private final VolumeRepository volumeRepository;
    private final ColorRepository colorRepository;

    @Override
    public void addProduct(ProductRequestDto requestDto) {

        if (productRepository.existsByproductName(requestDto.getProductName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PRODUCT);
        }

        String productUUID = UUID.randomUUID().toString();

        productRepository.save(requestDto.toEntity(productUUID));
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
    public List<ProductResponseDto> findProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductResponseDto::toDto).toList();
    }

    @Override
    @Transactional
    public void addProductOption(ProductOptionRequestDto requestDto) {

        if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }


        volumeRepository.save(VolumeRequestDto.toDto(VolumeRequestVo.builder()
            .name(requestDto.getVolumeName())
            .build()).toEntity()
        );
        colorRepository.save(ColorRequestDto.toDto(ColorRequestVo.builder()
                .name(requestDto.getColorName())
            .build()).toEntity()
        );

        productOptionRepository.save(requestDto.toEntity());
    }

    @Transactional
    @Override
    public void deleteProductOption(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
        );

        volumeRepository.delete(productOption.getVolume());
        productOptionRepository.delete(productOption);
    }

    @Override
    public ProductOptionResponseDto findProductOption(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
        );

        return ProductOptionResponseDto.toDto(productOption);
    }

    @Override
    public VolumeResponseDto findVolume(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
            () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
        );

        return VolumeResponseDto.toDto(productOption.getVolume());
    }

    @Override
    public List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice) {

        List<Product> products = productRepositoryCustom.getProductListWithPrice(MinPrice, MaxPrice);

        return products.stream().map(ProductResponseDto::toDto).toList();
    }


//    @Override
//    public void addMedia(MediaRequestDto requestDto) {
//
//        if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
//            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
//        }
//
//        mediaRepository.save(requestDto.toEntity());
//    }
//
//
//    @Override
//    public void deleteMedia(String productUUID) {
//
//        if (!productRepository.existsByProductUUID(productUUID)) {
//            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
//        }
//
//        mediaRepository.findByProductUUID(productUUID).orElseThrow(
//            () -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)
//        );
//    }
//
//
//    @Override
//    public MediaResponseDto findDetailMedia(String productUUID) {
//
//        ProductMedia productMedia = mediaRepository.findByProductUUID(productUUID).orElseThrow(
//            () -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)
//        );
//
//        if (productMedia.getProductChecked() == Boolean.FALSE) {
//            return null;
//        }
//
//        return MediaResponseDto.builder().build();
//    }
//
//
//    @Override
//    public MediaResponseDto findMedia(String productUUID) {
//
//        ProductMedia productMedia = mediaRepository.findByProductUUID(productUUID).orElseThrow(
//            () -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)
//        );
//
//        if (productMedia.getProductChecked() == Boolean.FALSE) {
//            return null;
//        }
//
//        if (productMedia.getThumbChecked() == Boolean.FALSE) { //썸네일
//            return null;
//        }
//
//        return MediaResponseDto.builder().build();
//    }


    @Override
    public List<Product> findProductsByProductUUID(List<String> productUUID) {

        return productUUID.stream()
            .map(productRepository::findByProductUUID)
            .map(products -> products.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)))
            .toList();

    }



}