package TRaMis8khae.starbucks.vendor.dto.out;


import TRaMis8khae.starbucks.vendor.entity.Volume;
import TRaMis8khae.starbucks.vendor.vo.in.VolumeRequestVo;
import TRaMis8khae.starbucks.vendor.vo.out.VolumeResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Getter
@Builder
@Slf4j
public class VolumeResponseDto {

	String name;

	public static VolumeResponseDto toDto(Volume volume) {
		log.info("volume name : {}" , volume.getName());
		return VolumeResponseDto.builder()
			.name(volume.getName())
			.build();
	}


	public VolumeResponseVo toVo() {
		log.info("volume name : {}" , name);
		return VolumeResponseVo.builder()
			.name(name)
			.build();
	}

}
