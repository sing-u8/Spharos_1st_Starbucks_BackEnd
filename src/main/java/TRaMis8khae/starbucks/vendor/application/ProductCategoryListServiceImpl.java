package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryListServiceImpl implements ProductCategoryListService{

    private final ProductRepository productRepository;
    private final ProductCategoryListRepository productCategoryListRepository;
    private final ProductCategoryListRepositoryCustom productCategoryListRepositoryCustom;

    @Override
    public void addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto) {

        Product product = productRepository.findById(productCategoryListRequestDto.getProductId())
            .orElseThrow( () -> new IllegalArgumentException("상품이 존재하지 않습니다."));


    }

    @Override
    public List<ProductCategoryListResponseDto> findProductsByCategory(String mainCode, String subCode) {
        return null;
    }

}