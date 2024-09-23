package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import TRaMis8khae.starbucks.media.dto.MediaAddRequestDto;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.product.dto.*;
import TRaMis8khae.starbucks.product.entity.*;
import TRaMis8khae.starbucks.product.infrastructure.*;
import TRaMis8khae.starbucks.product.vo.ColorRequestVo;
import TRaMis8khae.starbucks.product.vo.ProductAdditionalProductListRequestVo;
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
    private final ProductRepositoryCustom productRepositoryCustom;
    private final VolumeRepository volumeRepository;
    private final ColorRepository colorRepository;
    private final ProductAdditionalProductListRepository productAdditionalProductListRepository;

    @Override
    @Transactional
    public void addProduct(ProductRequestDto requestDto) {

        if (productRepository.existsByproductName(requestDto.getProductName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PRODUCT);
        }

        String productUUID = CodeGenerator.generateCode(36);

        productRepository.save(requestDto.toEntity(productUUID));
    }

    @Override
    public void updateProduct(String uuid, ProductUpdateRequestDto requestDto) {

        Product product = productRepository.findByProductUUID(uuid).orElseThrow(
            () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
        );

        productRepository.save(requestDto.toEntity(product));
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
        //추가상품이 아닌 상품들만 찾기로직 추가
        return products.stream().map(ProductResponseDto::toDto).toList();
    }

    @Override
    @Transactional
    public void addProductOption(ProductOptionRequestDto requestDto) {

        if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        Volume volume = volumeRepository.findByName(requestDto.getVolumeName())
            .orElseGet(() -> volumeRepository.save(
                VolumeRequestDto.toDto(VolumeRequestVo.builder()
                    .name(requestDto.getVolumeName())
                    .build()).toEntity()
            ));

        Color color = colorRepository.findByName(requestDto.getColorName())
            .orElseGet(() -> colorRepository.save(
                toDto(ColorRequestVo.builder()
                    .name(requestDto.getColorName())
                    .build()).toEntity()
            ));

        productOptionRepository.save(requestDto.toEntity(volume, color));
    }

    @Override
    public void updateProductOption(ProductOptionRequestDto requestDto) {

    }

    @Transactional
    @Override
    public void deleteProductOption(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
        );

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
    public ColorResponseDto findColor(String productUUID) {

        ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
        );

        return ColorResponseDto.toDto(productOption.getColor());
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
    public List<Product> findProductsByProductUUID(List<String> productUUID) {

        return productUUID.stream()
            .map(productRepository::findByProductUUID)
            .map(products -> products.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)))
            .toList();
    }

    @Override
    public void addProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto) {

        productAdditionalProductListRepository.save(requestDto.toEntity());
    }


    @Override
    public void updateProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto) {
    }


    @Override
    public void deleteProductAdditionalProduct(String uuid) {

    }


    @Override
    public List<String> findProductAdditionalProduct(String uuid) {

        Product product = productRepository.findByProductUUID(uuid).orElseThrow(
            () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
        );

        List<String> UUIDs = null;

        if (product.getIsAdditionalTogether()) {
            UUIDs = productAdditionalProductListRepository.findAllByProductUUID(uuid)
                .stream().map(ProductAdditionalProductList::getAdditionalUUID).toList();

        }

        return UUIDs;
    }

}