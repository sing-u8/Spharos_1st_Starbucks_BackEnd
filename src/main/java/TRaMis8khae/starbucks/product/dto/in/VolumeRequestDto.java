package TRaMis8khae.starbucks.product.dto.in;


import TRaMis8khae.starbucks.product.entity.Volume;
import TRaMis8khae.starbucks.product.vo.in.VolumeRequestVo;
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
