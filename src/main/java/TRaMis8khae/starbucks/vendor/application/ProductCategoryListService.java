package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.common.utils.CursorPage;
import TRaMis8khae.starbucks.vendor.dto.in.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;

import java.util.List;

public interface ProductCategoryListService {
    ProductCategoryList addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto);
    List<ProductCategoryListResponseDto> findProductsByCategories(String topCode, String middleCode, String bottomCode);

    CursorPage<String> getProductCategoryListByCategories(String topCategoryCode, String middleCategoryCode, String bottomCategoryCode, Long lastId, Integer pageSize, Integer page);
}