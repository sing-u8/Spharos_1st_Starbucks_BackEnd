package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.vendor.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.VolumeResponseDto;
import TRaMis8khae.starbucks.vendor.entity.ProductOption;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductOptionRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.VolumeRepository;
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
		if (!requestDto.getName().isEmpty()) {
			volumeRepository.findByName(requestDto.getName())
					.orElseGet(() -> volumeRepository.save(requestDto.toEntity()));
		}
	}

	@Override
	public VolumeResponseDto findVolume(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		return VolumeResponseDto.toDto(productOption.getVolume());
	}

}
