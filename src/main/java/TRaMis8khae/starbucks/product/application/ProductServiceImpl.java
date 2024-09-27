package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import TRaMis8khae.starbucks.common.utils.CursorPage;
import TRaMis8khae.starbucks.event.dto.in.EventProductRequestDto;
import TRaMis8khae.starbucks.media.application.MediaService;
import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.infrastructure.MediaRepository;
import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.out.EventProductResponseDto;
import TRaMis8khae.starbucks.product.dto.out.ProductDetailResponseDto;
import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.*;
import TRaMis8khae.starbucks.product.infrastructure.*;
import TRaMis8khae.starbucks.product.vo.out.ProductDetailResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductRepositoryCustom productRepositoryCustom;
    private final ProductMediaListRepository productMediaListRepository;
    private final MediaRepository mediaRepository;
    private final MediaService mediaService;

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
    public Slice<EventProductResponseDto> findProductsByProductUUID(List<String> productUUID, Pageable pageable) {

        boolean hasNext = false;

        List<EventProductResponseDto> eventProductResponseDtos = new ArrayList<>();
        List<Product> products = productRepository.findByProductUUIDIn(productUUID, pageable);
        Media media = null;

        for (Product product : products) {
            List<ProductMediaList> productMediaLists = productMediaListRepository.findByProductUUID(product.getProductUUID());

            for (ProductMediaList productMediaList : productMediaLists) {
                media = mediaRepository.findById(productMediaList.getMediaId()).orElseThrow(
                    () -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)
                );

                if (media.getThumbChecked()) {
                    break;
                }
            }
            eventProductResponseDtos.add(EventProductResponseDto.toDto(product, media));
        }

        if (eventProductResponseDtos.size() == pageable.getPageSize()) {
            hasNext = true;
        }

        return new SliceImpl<>(eventProductResponseDtos, pageable, hasNext);
    }

    @Override
    @Transactional
    public ProductDetailResponseDto findDetailProduct(String productUUID) {

        Product product = productRepository.findByProductUUID(productUUID)
            .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));
        List<ProductMediaList> productMediaLists = productMediaListRepository.findByProductUUID(productUUID);
        List<Long> productDetailImageIds = new ArrayList<>();
        List<Long> productThumbImageIds = new ArrayList<>();

        product.plusViewCount();
        productRepository.save(product);

        for (ProductMediaList productMediaList : productMediaLists) {
            Media media = mediaRepository.findById(productMediaList.getMediaId()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)
            );

            if (media.getThumbChecked()) {
                productThumbImageIds.add(media.getId());
            }
            else productDetailImageIds.add(media.getId());

//            productDetailImageIds.add(media.getId());
            log.info("productImageUrl : {} ", media.getMediaUrl() );


        }

        return ProductDetailResponseDto.toDto(product, productThumbImageIds, productDetailImageIds);
    }
}