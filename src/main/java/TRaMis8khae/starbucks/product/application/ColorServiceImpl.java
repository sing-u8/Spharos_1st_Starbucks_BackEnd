package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.product.dto.ColorRequestDto;
import TRaMis8khae.starbucks.product.dto.ColorResponseDto;
import TRaMis8khae.starbucks.product.entity.Color;
import TRaMis8khae.starbucks.product.entity.ProductOption;
import TRaMis8khae.starbucks.product.infrastructure.ColorRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductOptionRepository;
import TRaMis8khae.starbucks.product.vo.ColorRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static TRaMis8khae.starbucks.product.dto.ColorRequestDto.toDto;


@Slf4j
@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

	private final ProductOptionRepository productOptionRepository;
	private final ColorRepository colorRepository;

	public Color addColor(ColorRequestDto requestDto) {

		return colorRepository.findByName(requestDto.getName())
			.orElseGet(() -> colorRepository.save(
				toDto(ColorRequestVo.builder()
					.name(requestDto.getName())
					.build()).toEntity()
			));
	}

	@Override
	public ColorResponseDto findColor(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		return ColorResponseDto.toDto(productOption.getColor());
	}

}
