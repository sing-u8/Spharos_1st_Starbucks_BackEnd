package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.in.ProductMediaListRequestDto;
import TRaMis8khae.starbucks.product.infrastructure.ProductMediaListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductMediaServiceImpl implements ProductMediaService{

	private final ProductMediaListRepository productMediaListRepository;

	@Override
	public void addProductMedia(ProductMediaListRequestDto requestDto) {
		productMediaListRepository.save(requestDto.toEntity());
	}

}
