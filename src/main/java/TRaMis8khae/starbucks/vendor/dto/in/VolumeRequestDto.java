package TRaMis8khae.starbucks.vendor.dto.in;


import TRaMis8khae.starbucks.vendor.entity.Volume;
import TRaMis8khae.starbucks.vendor.vo.in.VolumeRequestVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class VolumeRequestDto {

	String name;

	String productUUID;

	public static VolumeRequestDto toDto(VolumeRequestVo volumeRequestVo) {

		return VolumeRequestDto.builder()
			.name(volumeRequestVo.getName())
			.build();
	}


	public Volume toEntity() {

		return Volume.builder()
			.name(name)
			.build();
	}
}
