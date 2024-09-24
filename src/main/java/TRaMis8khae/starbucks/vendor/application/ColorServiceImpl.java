package TRaMis8khae.starbucks.vendor.application;


import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.vendor.dto.in.ColorRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ColorResponseDto;
import TRaMis8khae.starbucks.vendor.entity.ProductOption;
import TRaMis8khae.starbucks.vendor.infrastructure.ColorRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductOptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//member uuid 요청 - Authentication authentication

@Slf4j
@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

	private final ProductOptionRepository productOptionRepository;
	private final ColorRepository colorRepository;

	@Override
	public void addColor(ColorRequestDto requestDto) {

		colorRepository.findByName(requestDto.getName())
			.orElseGet(() -> colorRepository.save(requestDto.toEntity()));
	}

	@Override
	public ColorResponseDto findColor(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		return ColorResponseDto.toDto(productOption.getColor());
	}

}
