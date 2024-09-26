package TRaMis8khae.starbucks.admin.application;


import TRaMis8khae.starbucks.admin.dto.in.MenuCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.infrastructure.MenuCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class MenuCategoryServiceImpl implements MenuCategoryService {

	private final MenuCategoryRepository menuCategoryRepository;

	@Override
	public void addMenuCategory(MenuCategoryRequestDto requestDto) {
		menuCategoryRepository.save(requestDto.toEntity());
	}

}
