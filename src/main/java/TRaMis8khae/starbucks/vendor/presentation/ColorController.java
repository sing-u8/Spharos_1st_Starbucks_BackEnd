package TRaMis8khae.starbucks.vendor.presentation;


import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.vendor.application.ColorService;
import TRaMis8khae.starbucks.vendor.dto.in.ColorRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ColorResponseDto;
import TRaMis8khae.starbucks.vendor.vo.in.ColorRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-color")
public class ColorController {

	private final ColorService colorService;

	@PostMapping
	@Operation(summary = "색상", description = "색상을 추가합니다", tags = {"Color Service"})
	public BaseResponse<Void> createColor(@RequestBody ColorRequestVo requestVo) {

		colorService.addColor(ColorRequestDto.toDto(requestVo));
		return new BaseResponse<>();
	}

	@GetMapping("/{productUUID}")
	@Operation(summary = "색상 조회", description = "색상을 조회합니다", tags = {"Color Service"})
	public BaseResponse<ColorResponseDto> getColor(@PathVariable String productUUID) {

		return new BaseResponse<>(colorService.findColor(productUUID));
	}

}
