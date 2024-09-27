package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.in.ProductMediaListRequestDto;
import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductMediaListResponseDto;

import java.util.List;


public interface ProductMediaService {

	void addProductMedia(ProductMediaListRequestDto requestDto);

	List<ProductMediaListResponseDto> findProductMedia(String productUUID);

	Long findThumbMediaId(String productUUID);

	List<Long> findDetailMediaId(String productUUID);

}
