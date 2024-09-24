package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.product.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.product.dto.out.VolumeResponseDto;
import TRaMis8khae.starbucks.product.entity.ProductOption;
import TRaMis8khae.starbucks.product.infrastructure.ProductOptionRepository;
import TRaMis8khae.starbucks.product.infrastructure.VolumeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VolumeServiceImpl implements VolumeService{

	private final ProductOptionRepository productOptionRepository;
	private final VolumeRepository volumeRepository;

	@Override
	public void addVolume(VolumeRequestDto requestDto) {

		volumeRepository.findByName(requestDto.getName())
			.orElseGet(() -> volumeRepository.save(requestDto.toEntity()));
	}

	@Override
	public VolumeResponseDto findVolume(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		return VolumeResponseDto.toDto(productOption.getVolume());
	}

}
