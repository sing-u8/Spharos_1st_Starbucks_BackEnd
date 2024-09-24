package TRaMis8khae.starbucks.vendor.dto.out;


import TRaMis8khae.starbucks.vendor.entity.Volume;
import TRaMis8khae.starbucks.vendor.vo.in.VolumeRequestVo;
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
