package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.in.ProductOptionRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductOptionResponseDto;


public interface ProductOptionService {

	void addProductOption(ProductOptionRequestDto requestDto);

	void updateProductOption(ProductOptionRequestDto requestDto);

	void deleteProductOption(String productUUID);

	ProductOptionResponseDto findProductOption(String productUUID);

}
