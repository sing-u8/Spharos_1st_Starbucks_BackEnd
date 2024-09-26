package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.product.dto.in.ProductMediaListRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ProductDetailResponseDto;
import TRaMis8khae.starbucks.product.dto.out.ProductMediaListResponseDto;
import TRaMis8khae.starbucks.product.dto.out.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.ProductMediaList;
import TRaMis8khae.starbucks.product.infrastructure.ProductMediaListRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductMediaServiceImpl implements ProductMediaService{

	private final ProductMediaListRepository productMediaListRepository;
	private final ProductRepository productRepository;

	@Override
	public void addProductMedia(ProductMediaListRequestDto requestDto) {
		if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
			throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
		}
		productMediaListRepository.save(requestDto.toEntity());
	}


	@Override
	public List<ProductMediaListResponseDto> findProductMedia(String productUUID) {

		if (!productRepository.existsByProductUUID(productUUID)) {
			throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
		}
		List<ProductMediaList> productMediaLists = productMediaListRepository.findByProductUUID(productUUID);

		return productMediaLists.stream().map(
			ProductMediaListResponseDto::toDto).toList();
	}

}
