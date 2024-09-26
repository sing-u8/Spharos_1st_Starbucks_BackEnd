package TRaMis8khae.starbucks.vendor.application;


import TRaMis8khae.starbucks.vendor.dto.in.ProductOptionRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ProductOptionResponseDto;

import java.util.List;


public interface ProductOptionService {

	void addProductOption(ProductOptionRequestDto requestDto);

	void updateProductOption(ProductOptionRequestDto requestDto);

	void deleteProductOption(String productUUID);

	ProductOptionResponseDto findProductOption(String productUUID);

	List<String> findProductUUIDSByVolume(String volumeName);

}
