package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListResponseDto;

import java.util.List;

public interface ProductCategoryListService {
    void addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto);
    List<ProductCategoryListResponseDto> findProductsByCategories(String topCode, String middleCode, String bottomCode);
    List<ProductCategoryListResponseDto> findProductsByTopCategory(String topCode);

}