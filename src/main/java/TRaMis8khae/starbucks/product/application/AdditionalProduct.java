package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.ProductAdditionalProductListRequestDto;

import java.util.List;


public interface AdditionalProduct {

	void addProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto);

	void updateProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto);

	List<String> findProductAdditionalProduct(String uuid);

}
