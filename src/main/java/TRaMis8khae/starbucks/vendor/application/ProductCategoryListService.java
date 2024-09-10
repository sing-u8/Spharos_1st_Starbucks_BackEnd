package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListResponseDto;

import java.util.List;

public interface ProductCategoryListService {

    void addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto);
    List<ProductCategoryListResponseDto> findProductsByCategory(String mainCode, String subCode);

}