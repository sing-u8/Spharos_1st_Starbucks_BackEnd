package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.product.dto.ProductOptionRequestDto;
import TRaMis8khae.starbucks.product.dto.ProductOptionResponseDto;
import TRaMis8khae.starbucks.product.dto.VolumeRequestDto;
import TRaMis8khae.starbucks.product.entity.Color;
import TRaMis8khae.starbucks.product.entity.ProductOption;
import TRaMis8khae.starbucks.product.entity.Volume;
import TRaMis8khae.starbucks.product.infrastructure.ColorRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductOptionRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.product.infrastructure.VolumeRepository;
import TRaMis8khae.starbucks.product.vo.ColorRequestVo;
import TRaMis8khae.starbucks.product.vo.VolumeRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static TRaMis8khae.starbucks.product.dto.ColorRequestDto.toDto;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductOptionServiceImpl implements ProductOptionService{

	private final ProductRepository productRepository;
	private final VolumeRepository volumeRepository;
	private final ColorRepository colorRepository;
	private final ProductOptionRepository productOptionRepository;

	@Override
	@Transactional
	public void addProductOption(ProductOptionRequestDto requestDto) {

		if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
			throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
		}

		Volume volume = volumeRepository.findByName(requestDto.getVolumeName())
			.orElseGet(() -> volumeRepository.save(
				VolumeRequestDto.toDto(VolumeRequestVo.builder()
					.name(requestDto.getVolumeName())
					.build()).toEntity()
			));

		Color color = colorRepository.findByName(requestDto.getColorName())
			.orElseGet(() -> colorRepository.save(
				toDto(ColorRequestVo.builder()
					.name(requestDto.getColorName())
					.build()).toEntity()
			));

		productOptionRepository.save(requestDto.toEntity(volume, color));
	}

	@Override
	public void updateProductOption(ProductOptionRequestDto requestDto) {

	}

	@Transactional
	@Override
	public void deleteProductOption(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		productOptionRepository.delete(productOption);
	}

	@Override
	public ProductOptionResponseDto findProductOption(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		return ProductOptionResponseDto.toDto(productOption);
	}

}
