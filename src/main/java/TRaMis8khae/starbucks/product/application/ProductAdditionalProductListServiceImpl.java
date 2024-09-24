package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.product.dto.in.ProductAdditionalProductListRequestDto;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.ProductAdditionalProductList;
import TRaMis8khae.starbucks.product.infrastructure.ProductAdditionalProductListRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductAdditionalProductListServiceImpl implements ProductAdditionalProductListService {

	private final ProductRepository productRepository;
	private final ProductAdditionalProductListRepository productAdditionalProductListRepository;

	@Override
	public void addProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto) {

		productAdditionalProductListRepository.save(requestDto.toEntity());
	}


	@Override
	public void updateProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto) {
	}

	@Override
	public List<String> findProductAdditionalProduct(String uuid) {

		Product product = productRepository.findByProductUUID(uuid).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		List<String> UUIDs = null;

		if (product.getIsAdditionalTogether()) {
			UUIDs = productAdditionalProductListRepository.findAllByProductUUID(uuid)
				.stream().map(ProductAdditionalProductList::getAdditionalUUID).toList();

		}

		return UUIDs;
	}

}
