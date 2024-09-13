package TRaMis8khae.starbucks.product.dto;


import TRaMis8khae.starbucks.product.entity.Volume;
import TRaMis8khae.starbucks.product.vo.VolumeRequestVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class VolumeResponseDto {

	String name;

	public static VolumeResponseDto toDto(Volume volume) {

		return VolumeResponseDto.builder()
			.name(volume.getName())
			.build();
	}


	public VolumeRequestVo toVo() {

		return VolumeRequestVo.builder()
			.name(name)
			.build();
	}


}
