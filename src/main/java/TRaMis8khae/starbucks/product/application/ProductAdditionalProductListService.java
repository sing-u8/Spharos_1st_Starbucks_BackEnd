package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.in.ProductAdditionalProductListRequestDto;

import java.util.List;


public interface ProductAdditionalProductListService {

	void addProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto);

	void updateProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto);

	List<String> findProductAdditionalProduct(String uuid);

}
