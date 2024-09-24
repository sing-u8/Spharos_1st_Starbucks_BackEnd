package TRaMis8khae.starbucks.product.presentation;


import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.product.application.VolumeService;
import TRaMis8khae.starbucks.product.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.product.dto.out.VolumeResponseDto;
import TRaMis8khae.starbucks.product.vo.in.VolumeRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-volume")
public class VolumeController {

	private final VolumeService volumeService;

	@Operation(summary = "상품 용량 추가", description = "상품의 용량을 추가합니다", tags = {"Product Volume Service"})
	@PostMapping
	public BaseResponse<Void> createVolume(@RequestBody VolumeRequestVo requestVo) {

		volumeService.addVolume(VolumeRequestDto.toDto(requestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 용량 가져오기", description = "상품의 용량을 가져옵니다", tags = {"Product Volume Service"})
	@GetMapping("/{productUUID}")
	public BaseResponse<VolumeResponseDto> getVolume(@PathVariable String productUUID) {

		return new BaseResponse<>(volumeService.findVolume(productUUID));
	}

}
