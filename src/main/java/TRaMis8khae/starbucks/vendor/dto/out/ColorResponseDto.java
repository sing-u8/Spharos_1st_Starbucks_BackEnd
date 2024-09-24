package TRaMis8khae.starbucks.vendor.dto.out;


import TRaMis8khae.starbucks.vendor.entity.Color;
import TRaMis8khae.starbucks.vendor.vo.out.ColorResponseVo;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ColorResponseDto {

    String name;

    public static ColorResponseDto toDto(Color color) {

        return ColorResponseDto.builder()
                .name(color.getName())
                .build();
    }


    public ColorResponseVo toVo() {

        return ColorResponseVo.builder()
                .name(name)
                .build();
    }
}
