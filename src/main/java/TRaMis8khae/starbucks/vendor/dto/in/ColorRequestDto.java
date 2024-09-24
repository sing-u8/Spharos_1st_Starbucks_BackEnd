package TRaMis8khae.starbucks.vendor.dto.in;


import TRaMis8khae.starbucks.vendor.entity.Color;
import TRaMis8khae.starbucks.vendor.vo.in.ColorRequestVo;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ColorRequestDto {

	String name;

	String productUUID;

	public static ColorRequestDto toDto(ColorRequestVo colorRequestVo) {

		return ColorRequestDto.builder()
			.name(colorRequestVo.getName())
			.build();
	}

	public Color toEntity() {

		return Color.builder()
			.name(name)
			.build();
	}

}
