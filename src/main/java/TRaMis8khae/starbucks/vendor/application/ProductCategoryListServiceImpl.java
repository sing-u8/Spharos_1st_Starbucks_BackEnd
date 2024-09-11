package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryListServiceImpl implements ProductCategoryListService{

    private final ProductRepository productRepository;
    private final ProductCategoryListRepository productCategoryListRepository;
    private final ProductCategoryListRepositoryCustom productCategoryListRepositoryCustom;

    @Override
    public void addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto) {

        Product product = productRepository.findByProductUUID(productCategoryListRequestDto.getProductUUID())
            .orElseThrow( () -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        productCategoryListRepository.save(productCategoryListRequestDto.toEntity(product));

    }


    @Override
    public List<ProductCategoryListResponseDto> findProductsByCategories(String topCode, String middleCode, String bottomCode) {
        return null;
    }

    @Override
    public List<ProductCategoryListResponseDto> findProductsByTopCategory(String topCode) {
        //메인 카테고리에 해당하는 상품 리스트 찾기
        List<ProductCategoryList> productCategoryList = productCategoryListRepositoryCustom.findProductsByCategories(topCode, null);

        return productCategoryList.stream().map(ProductCategoryListResponseDto::toDto).toList();
    }

}