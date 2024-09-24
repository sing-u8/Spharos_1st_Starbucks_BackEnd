package TRaMis8khae.starbucks.vendor.application;


import TRaMis8khae.starbucks.vendor.dto.in.ProductOptionRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ProductOptionResponseDto;


public interface ProductOptionService {

	void addProductOption(ProductOptionRequestDto requestDto);

	void updateProductOption(ProductOptionRequestDto requestDto);

	void deleteProductOption(String productUUID);

	ProductOptionResponseDto findProductOption(String productUUID);

}
