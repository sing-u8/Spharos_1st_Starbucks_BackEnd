package TRaMis8khae.starbucks.admin.dto.out;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.vo.MainCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainCategoryResponseDto {

    private String name;
    private Integer sequence;
    private String code;

    public static MainCategoryResponseDto toDto(MainCategory mainCategory) {
        return MainCategoryResponseDto.builder()
                .name(mainCategory.getName())
                .sequence(mainCategory.getSequence())
                .code(mainCategory.getCode())
                .build();
    }

    public MainCategoryResponseVo toVo() {
        return MainCategoryResponseVo.builder()
                .code(code)
                .build();
    }

}