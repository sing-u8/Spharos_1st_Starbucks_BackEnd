package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;

import java.util.List;

public interface ProductCategoryListService {
    void addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto);
    List<ProductCategoryListResponseDto> findProductsByCategory(Integer mainId, Integer subId);
}
