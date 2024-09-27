package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.infrastructure.MediaRepository;
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

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductMediaServiceImpl implements ProductMediaService{

	private final ProductMediaListRepository productMediaListRepository;
	private final ProductRepository productRepository;
	private final MediaRepository mediaRepository;

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

	@Override
	public Long findThumbMediaId(String productUUID) {

		if (!productRepository.existsByProductUUID(productUUID)) {
			throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
		}

		List<ProductMediaList> productMediaLists = productMediaListRepository.findByProductUUID(productUUID);

		for (ProductMediaList productMediaList : productMediaLists) {
			Media media = mediaRepository.findById(productMediaList.getMediaId()).orElseThrow(
				() -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)
			);

			if (media.getThumbChecked()) {
				return media.getId();
			}
		}

		return null;
	}

	@Override
	public List<Long> findDetailMediaId(String productUUID) {

		if (!productRepository.existsByProductUUID(productUUID)) {
			throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
		}
		ArrayList<Long> detailIds = new ArrayList<>();
		List<ProductMediaList> productMediaLists = productMediaListRepository.findByProductUUID(productUUID);

		for (ProductMediaList productMediaList : productMediaLists) {
			Media media = mediaRepository.findById(productMediaList.getMediaId()).orElseThrow(
				() -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)
			);

			if (!media.getThumbChecked()) {
				detailIds.add(media.getId());
			}
		}

		return detailIds;
	}
}
