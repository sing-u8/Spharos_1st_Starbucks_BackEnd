package TRaMis8khae.starbucks.product.dto;


import TRaMis8khae.starbucks.product.entity.Color;
import TRaMis8khae.starbucks.product.entity.Volume;
import TRaMis8khae.starbucks.product.vo.ColorRequestVo;
import lombok.Builder;


@Builder
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
